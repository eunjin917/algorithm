import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // N, M 입력 : 4 3
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // (N줄 동안) 테이블 입력
        int[][] table = new int[N+1][N+1];
        for (int x = 1; x <= N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 1; y <= N; y++) {
                table[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        // 누적합 계산
        int[][] pSum = new int[N+1][N+1];
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                pSum[x][y] = pSum[x-1][y] + pSum[x][y-1] - pSum[x-1][y-1] + table[x][y];
            }
        }

        // 누적합 출력
        // for (int x = 1; x <= N; x++) {
        //     for (int y = 1; y <= N; y++) {
        //         bw.write(pSum[x][y]+" ");
        //     }
        //     bw.write("\n");
        // }

        // (M줄 동안) x1 y1 x2 y2 입력 및 구간합 출력 : 2 2 3 4, 27
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            bw.write(pSum[x2][y2] - pSum[x2][y1 - 1] - pSum[x1 - 1][y2] + pSum[x1 - 1][y1 - 1] + "\n");
        }

        bw.close();
    }
}
