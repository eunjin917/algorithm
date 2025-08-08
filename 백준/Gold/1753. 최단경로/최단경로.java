import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int loc;
    int dist;

    Edge(int loc, int dist) {
        this.loc = loc;
        this.dist = dist;
    }

    public int compareTo(Edge o) {
        return this.dist - o.dist;
    }
}

public class Main {
    static int V, E;
    static int INF = 1000000000;
    static int[] dist = new int[20003];

    static List<Edge>[] adj = new ArrayList[20003];
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    static void dijkstra(int st) {
        dist[st] = 0;
        pq.add(new Edge(st, 0));
        while (!pq.isEmpty()) {
            int here = pq.peek().loc;
            int cost = pq.peek().dist;
            pq.poll();
            if (dist[here] < cost)
                continue;

            for (int i = 0; i < adj[here].size(); i++) {
                int there = adj[here].get(i).loc;
                int nextDist = cost + adj[here].get(i).dist;
                if (nextDist < dist[there]) {
                    dist[there] = nextDist;
                    pq.add(new Edge(there, nextDist));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= V; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = INF;
        }

        int u, v, w, start;
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            adj[u].add(new Edge(v, w));
        }
        dijkstra(start);

        for (int i = 1; i <= V; i++) {
            int ret = dist[i];
            if (ret == INF)
                bw.write("INF\n");
            else
                bw.write(ret + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
