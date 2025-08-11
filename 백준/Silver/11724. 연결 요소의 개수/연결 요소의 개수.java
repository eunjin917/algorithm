import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] adj = new ArrayList[1002];
    static boolean[] visited = new boolean[1002];

    static void dfs(int here) {

        for (int i = 0; i < adj[here].size(); i++) {
            int there = adj[here].get(i);
            if (!visited[there]) {
                visited[there] = true;
                dfs(there);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        int a, b;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        int ret = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i);
                ret++;
            }
        }
        bw.write(ret + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
