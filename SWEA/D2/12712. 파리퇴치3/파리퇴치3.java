import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 파리퇴치3
// - 완전탐색
public class Solution {
	final static int[][] operatorPlus = { {-1,0}, {1,0}, {0,-1}, {0,1} };	// 상하좌우
	final static int[][] operatorCross = { {-1,-1}, {-1,1}, {1,-1}, {1,1} };	// 1379
	static int T;
	static int N;
	static int M;
	static int[][] flies;
	
	static int getSum(int y, int x, int[][] operator) {
		int sum = flies[y][x];
		for (int d=1; d<M; d++) {
			for (int[] o : operator) {
				int ny = y + o[0]*d;
				int nx = x + o[1]*d;
				if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
				sum += flies[ny][nx];
			}
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for (int testCase=1; testCase<=T; testCase++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			flies = new int[N][N];
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					 flies[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int maxSum = 0;
			for (int y=0; y<N; y++) {
				for (int x=0; x<N; x++) {
					int sumPlus = getSum(y, x, operatorPlus);
					int sumCross = getSum(y, x, operatorCross);
					maxSum = Math.max(maxSum, Math.max(sumPlus, sumCross));
				}
			}
			System.out.println("#"+testCase+" "+maxSum);
		}
	}
}