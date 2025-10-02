import java.io.*;
import java.util.*;

class Main {
    static int[] nums;
    static boolean[] visited;
    static int N;
    static int S;
    static int answer;

    public static void subset(int depth, int sum) {
        if (depth == N) {
            if (sum == S) answer++;
            return;
        }

        visited[depth] = true;
        subset(depth+1, sum+nums[depth]);

        visited[depth] = false;
        subset(depth+1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 부분집합
        visited = new boolean[N];
        subset(0, 0);

        // 출력
        if (S == 0) answer--;
        System.out.println(answer);
    }
}