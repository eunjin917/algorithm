import java.io.*;
import java.util.*;

public class Main {
    final static int N_MAX = 10000;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // dp 초기화
        dp = new int[N_MAX + 1][4];
    
        for (int n = 1; n <= 3; n++) {
            for (int k = 1; k <= 3; k++) {
                dp[n][k] = 1;
            }
            dp[n][0] = n;
        }
        
        for (int n = 4; n <= N_MAX; n++) {
            dp[n][1] = 1;
            dp[n][2] = dp[n-2][2] + 1; // dp[n][2] = dp[n-2][2] + dp[n-2][1]
            dp[n][3] = dp[n-3][0];
            dp[n][0] = 1 + dp[n][2] + dp[n][3]; // dp[n][0] = dp[n][1] + dp[n][2] + dp[n][3];
        }

        // for (int n = 1; n <= N_MAX; n++) {
        //     for (int k = 0; k <= 3; k++) {
        //         bw.write(dp[n][k]+" ");
        //     }
        //     bw.write("\n");
        // }
        
        // 테스트케이스 T 입력 : 3
        int T = Integer.parseInt(br.readLine());
        
        // (T번 반복) N 입력 : 4
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(dp[N][0]+"\n");
        }
        
        bw.close();
    }
}
