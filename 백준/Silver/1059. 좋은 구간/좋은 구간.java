import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        int L = Integer.parseInt(br.readLine());
        int[] S = new int[L];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<L; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        int n = Integer.parseInt(br.readLine());

        // 정렬
        Arrays.sort(S);

        // 구간 찾기
        int start = 0;
        int end = 0;
        // 1~S[0]
        if (n < S[0]) {
        	start = 1;
        	end = S[0] - 1;
        }
        // S[0] ~ S[L]
        for (int i=0; i<L; i++) {
            if (S[i] < n && n < S[i+1]) {
                start = S[i] + 1;
                end = S[i+1] - 1;
                break;
            }
        }
        // 구간이 없는 경우 종료
        if (start == 0 & end == 0) {
        	System.out.println(0);
        	return;
        }
        
        // 조합 계산
        int allC2 = (end-start+1)*(end-start)/2;
        int leftC2 = (n-start)*(n-start-1)/2;
        int rightC2 = (end-n)*(end-n-1)/2;
        System.out.println(allC2 - leftC2 - rightC2);
    }
}