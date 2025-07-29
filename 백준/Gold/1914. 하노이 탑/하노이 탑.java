import java.io.*;
import java.math.*;

public class Main {
	
	static StringBuffer sb = new StringBuffer();
	
	public static int recursion(int n, int from, int temp, int to) throws IOException {
		int K = 0;
		if (n == 0) {
			return K;
		}
		
		K += recursion(n-1, from, to, temp); // 얘네는 2번으로
		sb.append(from+" "+to+"\n");
		K++;
		K += recursion(n-1, temp, from, to); // 얘네는 다시 3번으로
		
		return K;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		int N = Integer.parseInt(br.readLine());
		
		if (N > 20) {
			System.out.println(BigInteger.valueOf(2).pow(N).subtract(BigInteger.ONE));
			return;
		}

		// 재귀
		int K = recursion(N, 1, 2, 3);
		
		// 출력
		System.out.println(K);
		System.out.println(sb.toString());
	}
}
