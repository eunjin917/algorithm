import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 맵 구성
		@SuppressWarnings("unchecked")
		List<Integer>[] map = (ArrayList<Integer>[]) new ArrayList[N + 1];
		for (int i=1; i<=N; i++) {
			map[i] = new ArrayList<>();
		}
		
		for (int j=1; j<=M; j++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u].add(v);
            map[v].add(u);
		}
		
		// 네트워크 그룹 찾기
		int groupCount = 0;
		boolean[] visited = new boolean[N+1];
		for (int i=1; i<=N; i++) {
			if (!visited[i]) {
				groupCount += BFS(i, map, visited);
				
			}
		}
		
		// 출력
		System.out.println(groupCount);
	}
	
	public static int BFS(int start, List<Integer>[] map, boolean[] visited) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(start);
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : map[cur]) {
				if (!visited[next]) {
					q.offer(next);
					visited[next] = true;
				}
			}
		}
		
		return 1;
	}
}