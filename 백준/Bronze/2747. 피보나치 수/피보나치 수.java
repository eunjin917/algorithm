import java.io.*;
import java.util.*;

public class Main {

    static int[] dp; // dp : 피보나치 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력 : 10
        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;

        // dp[N] 출력 : 55
        bw.write(fibo(N)+"\n");
        bw.close();
    }

    public static int fibo(int N) {
        // 메모이제이션
        if (dp[N] != 0 || N == 0) { // N == 0 : dp[0] = 0으로 초기화했기 때문
            return dp[N];
        }

        // 재귀
        dp[N] = fibo(N-1) + fibo(N-2);
        return dp[N];
    }
}
