import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Swea 1868 : 파핑파핑 지뢰찾기
// - 시뮬레이션 + DFS
public class Solution {
    static final int DIRECTION = 8;
    static final int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static final int[] dx = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
            // 입력
            int N = Integer.parseInt(br.readLine());
            char[][] map = new char[N][N];
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }
            // 초기화
            simulation(N, map);

            int check = 0;
            // 0 누르기
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (map[y][x] == '0' && !visited[y][x]) {
                        DFS(y, x, N, map, visited);
                        check++;
                    }
                }
            }
            // 나머지 누르기
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (!visited[y][x] && map[y][x] != '*') {
                        check++;
                    }
                }
            }

            // 출력
            System.out.println("#"+t+" "+check);
        }
    }

    static void simulation(int N, char[][] map) {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] == '*') { // 1. 가지치기 - 불가
                    continue;
                }
                int count = 0;
                for (int k = 0; k < DIRECTION; k++) {
                    int ny = y + dy[k];
                    int nx = x + dx[k];
                    if (isOut(ny, nx, N)) { // 1. 가지치기 - 범위
                        continue;
                    }
                    if (map[ny][nx] == '*') {   // 2. 계산
                        count++;
                    }
                }
                map[y][x] = (char) (count + '0');
            }
        }
    }

    static boolean isOut(int y, int x, int N) {
        return y < 0 || y >= N || x < 0 || x >= N;
    }

    static void DFS(int y, int x, int N, char[][] fields, boolean[][] visited) {
        if (isOut(y, x, N) || fields[y][x] == '*' || visited[y][x]) { // 1. 가지치기 - 범위, 불가, 방문
            return;
        }

        visited[y][x] = true;   //  2. 방문
        if (fields[y][x] == '0') {  // 3. 다음 방문 가능하면
            for (int k = 0; k < DIRECTION; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                DFS(ny, nx, N, fields, visited);    // 4. 재귀
            }
        }
    }
}
