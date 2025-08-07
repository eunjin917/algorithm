import java.util.*;
import java.io.*;

class Solution {

    public static int sum(int y, int x, int N, int M, int[][] table) {
        int sumThis = 0;
        for (int my=0; my<M; my++) {
            for (int mx=0; mx<M; mx++) {
                int ny = y + my;
                int nx = x + mx;
                if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
                    return 0;
                }
                sumThis += table[ny][nx];
            }
        }
        return sumThis;
    }
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            // 입력
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] table = new int[N][N];
            for (int y=0; y<N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x=0; x<N; x++) {
                    table[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            // 최대 영역 찾기
            int maxSum = 0;
            for (int y=0; y<N; y++) {
                for (int x=0; x<N; x++) {
                    int sumThis = sum(y, x, N, M, table);
                    maxSum = Math.max(sumThis, maxSum);
                }
            }

            // 출력
            System.out.printf("#%d %d%n", test_case, maxSum);
		}
	}
}
