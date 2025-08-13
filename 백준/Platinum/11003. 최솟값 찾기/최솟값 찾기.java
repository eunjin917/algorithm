import java.io.*;
import java.util.*;

class Elem {
    int value;
    int idx;

    public Elem(int value, int idx) {
        this.value = value;
        this.idx = idx;
    }
}

class recordMin {
    int value;
    int length;

    public recordMin(int value, int length) {
        this.value = value;
        this.length = length;
    }
}

public class Main {
    static int n, l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int num = 0;
        Deque<Elem> minDeq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            num = arr[i];

            if (minDeq.isEmpty()) {
                minDeq.addFirst(new Elem(num, i));
                sb.append(minDeq.peekFirst().value).append(" ");
                continue;
            }

            if (i >= minDeq.peekFirst().idx + l) {
                minDeq.pollFirst();
            }
            while (!minDeq.isEmpty() && (num <= minDeq.peekLast().value)) {
                minDeq.pollLast();
            }
            minDeq.addLast(new Elem(num, i));

            sb.append(minDeq.peekFirst().value).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
