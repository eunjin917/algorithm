import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] coins = new int[103];
    static int[][] ret = new int[10004][103];

    static int dp(int goal, int idx) {
        if (goal < 1)
            return 0;
        if (ret[goal][idx] > 0)
            return ret[goal][idx];
        if (ret[goal][idx] < 0)
            return 0;

        for (int i = 0; i <= idx; i++) {
            ret[goal][idx] += dp(goal - coins[idx], i);
        }
        if (ret[goal][idx] == 0) {
            ret[goal][idx] = -1;
            return 0;
        }
        return ret[goal][idx];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
            if (coins[i] <= k) {
                ret[coins[i]][i] = 1;
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += dp(k, i);
        }

        sb.append(result);
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}