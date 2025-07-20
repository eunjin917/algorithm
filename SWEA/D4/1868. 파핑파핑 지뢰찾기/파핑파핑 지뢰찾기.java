import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


// Swea 1868 : 파핑파핑 지뢰찾기
// - 시뮬레이션 + BFS
public class Solution {
    static final int DIRECTION = 8;
    static final int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static final int[] dx = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    static void simulation(int N, char[][] map, ArrayList<int[]> zeros) {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] == '*') { // 가지치기 - 불가
                    continue;
                }
                int count = 0;
                for (int k = 0; k < DIRECTION; k++) {
                    int ny = y + dy[k];
                    int nx = x + dx[k];
                    if (isOut(ny, nx, N)) { // 가지치기 - 범위
                        continue;
                    }
                    if (map[ny][nx] == '*') {   // 계산
                        count++;
                    }
                }
                map[y][x] = (char) (count + '0');
                if (map[y][x] == '0') { // BFS 시작점 모으기
                    zeros.add(new int[]{y, x});
                }
            }
        }
    }


    static void bfs(int y, int x, int N, char[][] map, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x}); // 1. 큐 시작
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();   // 2. 큐 꺼내기
            int cy = cur[0];
            int cx = cur[1];

            for (int k = 0; k < DIRECTION; k++) {   // 4. 다음
                int ny = cy + dy[k];
                int nx = cx + dx[k];

                if (isOut(ny, nx, N) || map[ny][nx] == '*' || visited[ny][nx]) { // 5. 가지치기 - 범위, 불가, 방문
                    continue;
                }

                visited[ny][nx] = true; // 7. 방문
                if (map[ny][nx] == '0') {
                    q.offer(new int[]{ny, nx}); // 8. 큐 다음 추가
                }
            }
        }
    }

    static boolean isOut(int y, int x, int N) {
        return y < 0 || y >= N || x < 0 || x >= N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트케이스
        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
            // 입력
            int N = Integer.parseInt(br.readLine());
            char[][] map = new char[N][N];
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }

            // 지뢰 개수 초기화 + BFS 시작점(0) 모으기
            ArrayList<int[]> zeros = new ArrayList<>();
            simulation(N, map, zeros);

            // 0 누르기
            boolean[][] visited = new boolean[N][N];
            int zeroCount = 0;
            for (int[] zero : zeros) {
                int y = zero[0];
                int x = zero[1];
                if (visited[y][x]) {    // 가지치기 - 방문
                    continue;
                }
                bfs(y, x, N, map, visited);
                zeroCount++;
            }

            // 나머지 누르기
            int anotherCount = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (!visited[y][x] && map[y][x] != '*') {
                        anotherCount++;
                    }
                }
            }

            // 출력
            int answer = zeroCount + anotherCount;
            System.out.println("#"+t+" "+answer);
        }
    }
}