import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long answer = 0;

        // 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long[] prefix = new long[N];

        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        // 누적합 초기 : i=0, j=0~
        prefix[0] = Integer.parseInt(st.nextToken());
        for (int j=1; j<N; j++) {
            prefix[j] = prefix[j-1] + Integer.parseInt(st.nextToken());
        }

        // 누적합 진행 : i<=j / i=1, j=1~
        Map<Long, Long> counter = new HashMap<>();
        for (int i=0; i<N; i++) {
            counter.put(prefix[i]%M, counter.getOrDefault(prefix[i]%M, 0L)+1);
        }
        
        // 0은 그대로도 가능
        answer += counter.getOrDefault(0L, 0L);
        
        // 2개씩 조합 찾기
        for (long value : counter.values()) {
            answer += value*(value-1)/2;  // vC2 = v(v-1)/2
        }

        // 출력
//        System.out.println(counter);
        System.out.println(answer);
    }
}