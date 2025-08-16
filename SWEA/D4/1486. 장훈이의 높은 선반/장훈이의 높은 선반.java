// Swea1486 : 장훈이의 높은 선반
// - 백트래킹
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트케이스
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            // 입력
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   // 점원이 N명
            int B = Integer.parseInt(st.nextToken());   // 선반의 높이
            int[] heights = new int[N];                 // 점원들의 키
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            // 부분집합
            int min = subSet(0, 0, N, B, heights);

            // 출력
            int answer = min - B;
            System.out.println("#"+t+" "+answer);
        }
    }

    static int subSet(int idx, int sum, int N, int B, int[] heights) {
        // 기저
        if (idx == N) {
            if (sum >= B) {
                return sum;                 // 선택 가능 조합 => min에 반영
            } else {
                return Integer.MAX_VALUE;   // 선택 불가 조합 => 무효
            }
        }

        // 가지치기
        if (sum >= B) { // 더 이상 선택해도, min이 아님 => min에 곧바로 반영
            return sum;
        }

        // 재귀 호출
        int pickMin = subSet(idx+1, sum+heights[idx], N, B, heights);   // 선택O
        int notPickMin = subSet(idx+1, sum, N, B, heights);             // 선택X
        
        return Math.min(pickMin, notPickMin);
    }
}