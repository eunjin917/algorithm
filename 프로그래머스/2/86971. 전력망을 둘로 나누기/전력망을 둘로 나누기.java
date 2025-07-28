import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    
    public int dfs(int startNode, List<List<Integer>> tree, boolean[] visited) {
        int count = 0;
        for (int node : tree.get(startNode)) {
            if (visited[node]) {
                continue;
            }
            visited[node] = true;
            count++;
            count += dfs(node, tree, visited);
        }
        return count;
    }
    
    public int solution(int n, int[][] wires) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] wire : wires) {
            tree.get(wire[0]).add(wire[1]);
            tree.get(wire[1]).add(wire[0]);
        }
        
        // for (int i = 1; i < tree.size(); i++) {
        //     System.out.println(i + " → " + tree.get(i));
        // }
        
        int minDiff = Integer.MAX_VALUE;
        for (int[] wire : wires) {
            int[] count = new int[2];
            for (int k=0; k<=1; k++) { // 수정
                boolean visited[] = new boolean[n+1];
                visited[wire[k]] = true;
                visited[wire[(k+1)%2]] = true;
                count[k] = dfs(wire[k], tree, visited);
            }
            int diff = count[1]-count[0];
            diff = diff > 0 ? diff : -diff;
            minDiff = Math.min(diff, minDiff);
        }
        
        return minDiff;
    }
}