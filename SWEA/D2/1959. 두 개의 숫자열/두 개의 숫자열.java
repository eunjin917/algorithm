import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		    int N = sc.nextInt();
		    int M = sc.nextInt();
		    
		    int[] A = new int[N];
		    int[] B = new int[M];
		    for (int n = 0; n < N; n++) A[n] = sc.nextInt();
		    for (int m = 0; m < M; m++) B[m] = sc.nextInt();
        
		    int maxSum = Integer.MIN_VALUE;
		    
		    int[] shortArr = N <= M ? A : B;
		    int[] longArr = N <= M ? B : A;
		    
		    int gap = longArr.length - shortArr.length;
		    
		    for (int offset = 0; offset <= gap; offset++) {
		            int curSum = 0;
		            for (int i = 0; i < shortArr.length; i++) curSum += shortArr[i]*longArr[i+offset];
                	maxSum = Math.max(maxSum, curSum);
		    }
            
		    System.out.println("#"+test_case+" "+maxSum);
		}
	}
}