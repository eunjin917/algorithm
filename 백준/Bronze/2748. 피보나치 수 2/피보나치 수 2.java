import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    static BigInteger[] dp; // dp : 피보나치 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력 : 10
        int N = Integer.parseInt(br.readLine());
        dp = new BigInteger[N+1];
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;

        // dp[N] 출력 : 55
        bw.write(fibo(N)+"\n");
        bw.close();
    }

    public static BigInteger fibo(int N) {
        // 메모이제이션
        if (dp[N] != null) {
            return dp[N];
        }

        // 재귀
        dp[N] = fibo(N-1).add(fibo(N-2)); // fibo(N-1) + fibo(N-2);
        return dp[N];
    }
}
