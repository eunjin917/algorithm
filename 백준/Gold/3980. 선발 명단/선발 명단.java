import java.io.*;
import java.util.*;

class Main {

    static int[][] s;
    static int[] positions;
    static int answer;

    public static void dfs(int player) {
        // 종료 조건
        if (player == 11) {
            int cur = 0;
            for (int j=0; j<11; j++) {
                cur += positions[j];
            }
            answer = Math.max(cur, answer);
            return;
        }

        // 진행
        for (int j=0; j<11; j++) {
            if (s[player][j] != 0 && positions[j] == 0) {
                positions[j] = s[player][j];
                dfs(player+1);
                positions[j] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트케이스
        int C = Integer.parseInt(br.readLine());
        for (int t=0; t<C; t++) {

            // 초기화
            s = new int[11][11];
            positions = new int[11];
            answer = 0;

            // 입력
            for (int i=0; i<11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<11; j++) {
                    s[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 계산 : 5^11 < 1,000,000
            dfs(0);

            // 출력
            System.out.println(answer);
        }
    }
}