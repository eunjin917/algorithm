
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int M;
	
	static ArrayList<Integer> nums = new ArrayList<>();
	
	static void print() {
		for (int num : nums) {
			System.out.print(num+" ");
		}
		System.out.println();
	}
	
	static void backtracking(int depth) {
		if (depth == M) {
			print();
			return;
		}
		

		
		for (int i=1; i<=N; i++) {
			if (nums.contains(i)) continue;	// pruning
			
			nums.add(i);
			backtracking(depth+1);
			nums.remove(nums.size()-1);
		}
	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		backtracking(0);
	}
}
