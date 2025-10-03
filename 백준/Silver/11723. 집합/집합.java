import java.io.*;
import java.util.*;

class Main {
    static int M;
    static int S;   // 20개 => 2^20 = int로 표현 가능

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 출력 준비
        StringBuilder sb = new StringBuilder();

        // 명령어
        M = Integer.parseInt(br.readLine());
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            String ins = st.nextToken();
            int x;
            switch (ins) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    S = S|(1<<x);
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    S = S&~(1<<x);
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    sb.append((S>>x) & 1).append('\n');
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    S = S^(1<<x);
                    break;
                case "all":
                    S = (1<<21) - 1;
                    break;
                case "empty":
                    S = 0;
                    break;
            }
        }

        // 출력
        System.out.println(sb.toString());
    }
}