import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    static BigInteger[] dp; // dp : 타일을 배치하는 경우의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // dp 초기화 : N의 범위 = 0~250
        dp = new BigInteger[251];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;
        dp[2] = BigInteger.valueOf(3);
        
        // (테스트케이스 반복)
        String line;
        while ((line = br.readLine()) != null) {
            // N 입력 : 2
            int N = Integer.parseInt(line);

            //  dp[N] 출력 : 3
            bw.write(f(N)+"\n");
        }
        
        bw.close();
    }

    public static BigInteger f(int N) {
        // 메모이제이션
        if (dp[N] != null) {
            return dp[N];
        }

        // 재귀
        dp[N] = f(N-1).add(f(N-2).multiply(BigInteger.valueOf(2))); // f(N-1) + f(N-2) * 2
        return dp[N];
    }
}
