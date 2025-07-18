import java.util.Scanner;
import java.io.FileInputStream;
 
 
// 숫자 배열 회전
// - 완전탐색
class Solution
{
    static Scanner sc;
     
    public static void main(String args[]) throws Exception
    {
        sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            for (int i=0; i<N; i++) for (int j=0; j<N; j++) arr[i][j] = sc.nextInt();
             
            System.out.println("#"+test_case);
            for (int i=0; i<N; i++) {
                StringBuilder sb90 = new StringBuilder();
                StringBuilder sb180 = new StringBuilder();
                StringBuilder sb270 = new StringBuilder();
                 
                for (int j=0; j<N; j++) {
                    sb90.append(arr[N-j-1][i]);
                    sb180.append(arr[N-i-1][N-j-1]);
                    sb270.append(arr[j][N-i-1]);
                     
                }
                System.out.println(sb90 + " " + sb180 + " " + sb270);
            }
        }
    }
}
