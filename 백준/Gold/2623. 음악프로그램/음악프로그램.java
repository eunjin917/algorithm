import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer>[] adjList = new ArrayList[N+1];
        int[] counts = new int[N+1];
        for (int i=1; i<=N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            int cur = Integer.parseInt(st.nextToken());
            for (int j=1; j<K; j++) {
                int next = Integer.parseInt(st.nextToken());

                adjList[cur].add(next);
                counts[next]++;

                cur = next;
            }
        }

        // 위상정렬
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        for (int i=1; i<=N; i++) {
            if (counts[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            answer.add(cur);

            for (int next : adjList[cur]) {
                counts[next]--;
                if (counts[next] == 0) q.offer(next);
            }
        }

        // 출력
        if (answer.size() < N) {    // 싸이클 판별
            System.out.println(0);
            return;
        }

        for (int i=0; i<N; i++) {
            System.out.println(answer.get(i));
        }
    }
}