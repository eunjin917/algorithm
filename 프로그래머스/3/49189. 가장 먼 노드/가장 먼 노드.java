import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    
    public void bfs(List<List<Integer>> vertex, int[] distances) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        distances[1] = 1;
        
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : vertex.get(cur)) {
                if (distances[next] == 0) {
                    q.offer(next);
                    distances[next] = distances[cur] + 1;
                }
            }
        }
    }
    
    public int solution(int n, int[][] edge) {
        List<List<Integer>> vertex = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            vertex.add(new ArrayList<>());
        }
        for (int[] ab : edge) {
            int a = ab[0];
            int b = ab[1];
            vertex.get(a).add(b);
            vertex.get(b).add(a);
        }

        // for (int i=1; i<=n; i++) {
        //     System.out.printf("%d) %s%n", i, vertex.get(i));
        // }
        
        int[] distances = new int[n+1];
        bfs(vertex, distances);
        // System.out.println(Arrays.toString(distances));
        
        int maxDistance = 0;
        for (int distance : distances) {
            maxDistance = Math.max(distance, maxDistance);
        }
        
        int count = 0;
        for (int distance : distances) {
            if (distance == maxDistance) {
                count++;
            }
        }
        
        return count;
    }
}