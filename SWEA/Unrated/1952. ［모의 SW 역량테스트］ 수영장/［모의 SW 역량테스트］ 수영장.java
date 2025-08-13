import java.io.*;
import java.util.*;

public class Solution {
    static int[] cost = new int[4];
    static int[] day = new int[13];
    static int[] dpArr = new int[13];
    static int ret = 10000000;

    static int dp(int month) {
        if (month < 1)
            return 0;
        if (dpArr[month] != 0) {
            return dpArr[month];
        }
        if (month == 12) {
            dpArr[12] = Math.min(dp(11) + cost[2], dp(10) + cost[2]);
            dpArr[12] = Math.min(dpArr[12], dp(9) + cost[2]);
            dpArr[12] = Math.min(dpArr[12], dp(11) + day[12]);
        } else if (month < 3) {
            dpArr[month] = dp(month - 1) + day[month];
        } else {
            dpArr[month] = Math.min(dp(month - 3) + cost[2], dp(month - 1) + day[month]);
        }

        return dpArr[month];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 12; i++) {
                day[i] = Integer.parseInt(st.nextToken());
                day[i] = Math.min(day[i] * cost[0], cost[1]);
            }
            ret = cost[3];

            for (int i = 1; i <= 12; i++) {
                dpArr[i] = 0;
            }

            dpArr[1] = day[1];
            ret = Math.min(ret, dp(12));

            sb.append("#").append(test_case).append(" ").append(ret).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
