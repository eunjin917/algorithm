import java.io.*;
import java.util.*;

class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node n = (Node)o;
        return this.y == n.y && this.x == n.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }
}

class Main {
    // 4방탐색
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int N;

    public static int bfs(char[][] map) {
        int answer = 0;

        boolean[][] visited = new boolean[N][N];

        // 전체 넣기
        Set<Node> set = new HashSet<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                set.add(new Node(i, j));
            }
        }

        // 여러 시작점 가능
        while (!set.isEmpty()) {
            Node firstNode = set.iterator().next();
            Queue<Node> q = new ArrayDeque<>();
            q.offer(new Node(firstNode.y, firstNode.x));
            visited[firstNode.y][firstNode.x] = true;
            set.remove(new Node(firstNode.y, firstNode.x));
            char group = map[firstNode.y][firstNode.x];

            // 1개 찾기
            while (!q.isEmpty()) {
                Node curNode = q.poll();

                for (int d=0; d<4; d++) {
                    int ny = curNode.y + dy[d];
                    int nx = curNode.x + dx[d];

                    if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                    if (visited[ny][nx]) continue;

                    if (group == map[ny][nx]) {
                        q.offer(new Node(ny, nx));
                        visited[ny][nx] = true;
                        set.remove(new Node(ny, nx));
                    }
                }
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        N = Integer.parseInt(br.readLine());
        char[][] nomap = new char[N][N];
        char[][] yesmap = new char[N][N];
        for (int i=0; i<N; i++) {
            String str = br.readLine();
            for (int j=0; j<N; j++) {
                yesmap[i][j] = nomap[i][j] = str.charAt(j);
                if (yesmap[i][j] == 'G') yesmap[i][j] = 'R';
            }
        }

        // 계산
        int noAnswer = bfs(nomap);
        int yesAnswer = bfs(yesmap);

        // 출력
        System.out.println(noAnswer+" "+yesAnswer);
    }
}