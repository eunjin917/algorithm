import java.io.*;
import java.util.*;

class Main {
    static int[] Lnums;
    static int[] Rnums;
    static Map<Integer, Integer> LcountMap;
    static Map<Integer, Integer> RcountMap;
    static int N;
    static int S;
    static long answer;

    public static void subset(int depth, int sum, int[] nums, Map<Integer, Integer> countMap, int max) {
        if (depth == max) {
            countMap.put(sum, countMap.getOrDefault(sum, 0)+1);
            return;
        }

        subset(depth+1, sum, nums, countMap, max);
        subset(depth+1, sum+nums[depth], nums, countMap, max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        int Rmax = N/2;
        if (N%2==1) {
            Rmax = N/2 + 1;
        }

        st = new StringTokenizer(br.readLine());
        Lnums = new int[N/2];
        Rnums = new int[Rmax];
        for (int i=0; i<N/2; i++) {
            Lnums[i] = Integer.parseInt(st.nextToken());
        }
        for (int i=0; i<Rmax; i++) {
            Rnums[i] = Integer.parseInt(st.nextToken());
        }

        // 부분집합
        LcountMap = new HashMap<>();
        RcountMap = new HashMap<>();
        subset(0, 0, Lnums, LcountMap, N/2);
        subset(0, 0, Rnums, RcountMap, Rmax);

        // 매칭 계산
        for (Map.Entry<Integer, Integer> entry : LcountMap.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();

            answer += (long) count * RcountMap.getOrDefault(S-key, 0);
        }

        // 출력
        if (S == 0) answer--;
        System.out.println(answer);
//        System.out.println(LcountMap);
//        System.out.println(RcountMap);
    }
}