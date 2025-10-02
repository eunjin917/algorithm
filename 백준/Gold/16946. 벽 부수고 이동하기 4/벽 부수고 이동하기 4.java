import java.io.*;
import java.util.*;

class Main {
    // 4방탐색
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[N][M];
        List<int[]> zeroList = new ArrayList<>();
        List<int[]> oneList = new ArrayList<>();
        int[][][] countIdMap = new int[N][M][2];
        int[][] answerMap = new int[N][M];
        int id = 1;

        for (int i=0; i<N; i++) {
            String str = br.readLine();
            for (int j=0; j<M; j++) {
                if (str.charAt(j) == '1') {
                    map[i][j] = true;
                    oneList.add(new int[]{i, j});
                }
                else {
                    zeroList.add(new int[]{i, j});
                }
            }
        }

        // flood fill : 여러 시작점
        boolean[][] visited = new boolean[N][M];
        for (int[] startNode : zeroList) {
            if (visited[startNode[0]][startNode[1]]) continue;

            // bfs : 개수 찾아서 업데이트
            Queue<int[]> q = new ArrayDeque<>();
            List<int[]> thisNodes = new ArrayList<>();

            visited[startNode[0]][startNode[1]] = true;
            q.offer(startNode);
            thisNodes.add(startNode);
            int count = 1;

            while (!q.isEmpty()) {
                int[] curNode = q.poll();

                for (int d=0; d<4; d++) {
                    int ny = curNode[0] + dy[d];
                    int nx = curNode[1] + dx[d];

                    if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                    if (visited[ny][nx]) continue;
                    if (map[ny][nx]) continue;

                    visited[ny][nx] = true;
                    q.offer(new int[]{ny, nx});
                    thisNodes.add(new int[]{ny, nx});
                    count++;
                }
            }

            // 개수 업데이트
            for (int[] node : thisNodes) {
                countIdMap[node[0]][node[1]][0] = count;
                countIdMap[node[0]][node[1]][1] = id;
            }
            id++;
        }

        // 1의 4방 합쳐서 계산
        for (int[] node : oneList) {
            Set<Integer> set = new HashSet<>();
            int sum = 1;

            for (int d=0; d<4; d++) {
                int ny = node[0] + dy[d];
                int nx = node[1] + dx[d];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;

                int curCount = countIdMap[ny][nx][0];
                int curId = countIdMap[ny][nx][1];
                if (set.contains(curId)) continue;

                set.add(curId);
                sum += curCount;
            }

            answerMap[node[0]][node[1]] = sum;
        }

        // 출력
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                System.out.print(answerMap[i][j]%10);
            }
            System.out.println();
        }
    }
}