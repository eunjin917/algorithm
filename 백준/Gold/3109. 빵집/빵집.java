import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] arr = new char[10003][503];
    static int[] dr = { -1, 0, 1 };

    static boolean search(int r, int c) {
        if (c == m - 1) {
            arr[r][c] = 'x';
            return true;
        }

        for (int i = 0; i < 3; i++) {
            int row = r + dr[i];
            if ((row >= 0) && (row < n) && (arr[row][c + 1] == '.')) {
                arr[row][c + 1] = 'x';
                if (search(row, c + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < m; j++) {
                char ch = line.charAt(j);
                arr[i][j] = ch;
            }
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (search(i, 0)) {
                ret++;
            }
        }
        sb.append(ret);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
