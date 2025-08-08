import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] adj = new ArrayList[502];
    static boolean[] visited = new boolean[502];
    static Queue<Integer> q = new LinkedList<>();
    static int ret = 0;

    static void bfs(int start) {
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int here = q.poll();

            for (int i = 0; i < adj[here].size(); i++) {
                int there = adj[here].get(i);
                if (!visited[there]) {
                    if (here != 1) {
                        visited[there] = true;
                        ret++;
                    } else {
                        visited[there] = true;
                        ret++;
                        q.add(there);
                    }

                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj[b].add(a);
            adj[a].add(b);
        }

        bfs(1);
        bw.write(ret + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
