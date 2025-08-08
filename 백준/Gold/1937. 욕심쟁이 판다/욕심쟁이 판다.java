import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map = new int[501][501];

    static int[] parentCnt = new int[250003];
    static int[] length = new int[250003];

    static List<Integer>[] childs = new ArrayList[250003];

    static int[] dr = { -1, 0, 0, 1 };
    static int[] dc = { 0, -1, 1, 0 };

    static Queue<Integer> q = new LinkedList<>();

    static boolean valid(int r, int c) {
        return ((r >= 0) && (r < n) && (c >= 0) && (c < n));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }
        for (int i = 0; i < n * n; i++) {
            childs[i] = new ArrayList<>();
        }

        int num, num2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num = map[i][j];
                for (int k = 0; k < 4; k++) {
                    int row = i + dr[k];
                    int col = j + dc[k];
                    if (valid(row, col)) {
                        num2 = map[row][col];
                        if (num > num2) {
                            childs[i * n + j].add(row * n + col);
                            parentCnt[row * n + col]++;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n * n; i++) {
            if (parentCnt[i] == 0) {
                q.add(i);
                length[i] = 1;
            }
        }
        while (!q.isEmpty()) {
            int here = q.poll();
            for (int i = 0; i < childs[here].size(); i++) {
                int there = childs[here].get(i);
                parentCnt[there]--;
                length[there] = Math.max(length[there], length[here] + 1);
                if (parentCnt[there] == 0) {
                    q.add(there);
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < n * n; i++) {
            ret = Math.max(ret, length[i]);
        }
        bw.write(ret + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
