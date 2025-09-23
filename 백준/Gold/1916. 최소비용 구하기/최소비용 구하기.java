import java.io.*;
import java.util.*;

class Main {

    static class Vertex implements Comparable<Vertex> {
        int no, dist;
        Vertex(int no, int dist) {
            this.no = no;
            this.dist = dist;
        }
        public int compareTo(Vertex o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] adj = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                adj[i][j] = Integer.MAX_VALUE;

                if (i == j) {
                    adj[i][j] = 0;
                }
            }
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if (cost < adj[from][to]) adj[from][to] = cost;
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end   = Integer.parseInt(st.nextToken());

        // 다익스트라

        int[] dist = new int[N+1];
        boolean[] visited = new boolean[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.offer(new Vertex(start, 0));

        while (!pq.isEmpty()) {
            Vertex cur = pq.poll();
            if (visited[cur.no]) continue;
            visited[cur.no] = true;
            if (cur.no == end) break; // 도착하면 종료

            for (int v = 1; v <= N; v++) {
                if (visited[v]) continue;
                if (adj[cur.no][v] == Integer.MAX_VALUE) continue;

                int nd = cur.dist + adj[cur.no][v];
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new Vertex(v, nd));
                }
            }
        }
        System.out.println(dist[end]);
    }
}