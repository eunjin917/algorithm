import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] trains = new int[N+1];  // 뒤(20) ~~~ 앞(1) / 0제외

        // 명령 입력
        int M = Integer.parseInt(st.nextToken());
        for (int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int ins = Integer.parseInt(st.nextToken());
            int i;
            int x;
            switch (ins) {
                case 1:
                    i = Integer.parseInt(st.nextToken());
                    x = Integer.parseInt(st.nextToken());
                    trains[i] |= (1<<x);
                    break;
                case 2:
                    i = Integer.parseInt(st.nextToken());
                    x = Integer.parseInt(st.nextToken());
                    trains[i] &= ~(1<<x);
                    break;
                case 3:
                    i = Integer.parseInt(st.nextToken());
                    trains[i] = (trains[i]<<1) & ~(1<<21);
                    break;
                case 4:
                    i = Integer.parseInt(st.nextToken());
                    trains[i] = (trains[i]>>1) & ~1;
                    break;
            }
        }

        // 건널 수 있는 기차 수 계산
        Set<Integer> set = new HashSet<>();
        for (int i=1; i<=N; i++) {
            set.add(trains[i]);
        }

        // 출력
        System.out.println(set.size());
//        System.out.println(Arrays.toString(trains));
    }
}