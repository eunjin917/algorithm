import java.io.*;
import java.util.*;

class Main {
    // 4방탐색
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    static int R;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        List<int[]> hooboList = new ArrayList<>();
        for (int i=0; i<R; i++) {
            String str = br.readLine();
            for (int j=0; j<C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] != '#') hooboList.add(new int[]{i, j});
            }
        }

        // flood fill
        boolean[][] visited = new boolean[R][C];
        int allVCount = 0;
        int allKCount = 0;
        for (int[] hoobo : hooboList) {
            int y = hoobo[0];
            int x = hoobo[1];

            if (visited[y][x]) continue;

            // bfs
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(hoobo);
            visited[y][x] = true;
            int vCount = 0;
            int kCount = 0;
            if (map[y][x] == 'v') vCount++;
            else if (map[y][x] == 'o') kCount++;

            while (!q.isEmpty()) {
                int[] cur = q.poll();

                for (int d=0; d<4; d++) {
                    int ny = cur[0] + dy[d];
                    int nx = cur[1] + dx[d];

                    if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
                    if (visited[ny][nx]) continue;
                    if (map[ny][nx] == '#') continue;

                    q.offer(new int[]{ny, nx});
                    visited[ny][nx] = true;
                    if (map[ny][nx] == 'v') vCount++;
                    else if (map[ny][nx] == 'o') kCount++;
                }
            }
            if (vCount < kCount) allKCount += kCount;
            else allVCount += vCount;
        }

        // 출력
        System.out.println(allKCount+" "+allVCount);
    }
}