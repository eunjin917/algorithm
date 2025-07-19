import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int DIRECTION = 4;
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};
    static int N, M;
    static int[][] map;
    static int[][] dist;
    static int startY, startX, endY, endX;

    static boolean isOut(int y, int x) {
        return (y < 0 || y >= N || x < 0 || x >= M);
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startY, startX}); // 1. 시작점 - 방문
        dist[startY][startX] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();   // 2. 큐 꺼내기
            int y = cur[0];
            int x = cur[1];

            if (y == endY && x == endX) {   // 3. 도착점 - 종료
                break;
            }

            for (int d = 0; d < DIRECTION; d++) {   // 4. 다음
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (isOut(ny, nx) || map[ny][nx] == 0 || dist[ny][nx] != 0) { // 5. 가지치기 - 범위, 불가, 방문
                    continue;
                }

                q.offer(new int[]{ny, nx}); // 6. 큐 넣기
                dist[ny][nx] = dist[y][x] + 1;  // 6. 거리계산
            }
        }
        return dist[endY][endX];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // y크기
        M = Integer.parseInt(st.nextToken());   // x크기
        map = new int[N][M];
        for (int y = 0; y < N; y++) {
            map[y] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        // 계산
        dist = new int[N][M];
        startY = 0;
        startX = 0;
        endY = N - 1;
        endX = M - 1;
        int count = bfs();

        // 출력
        System.out.println(count);
    }
}
