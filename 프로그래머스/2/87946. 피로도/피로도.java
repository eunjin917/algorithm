class Solution {
    
    public int backTracking(int depth, int maxDepth, int k, int[][] dungeons, boolean[] visited) {
        if (depth > dungeons.length) {
            return maxDepth;
        }
        
        maxDepth = Math.max(depth, maxDepth);
        
        // System.out.printf("%d) %d%n", depth, k);
        
        for (int j=0; j<dungeons.length; j++) {
            if (!visited[j]) {
                if (k < dungeons[j][0]) {
                    continue;
                }
                int newK = k - dungeons[j][1];
                if (newK < 0) {
                    continue;
                }
                visited[j] = true;
                maxDepth = backTracking(depth+1, maxDepth, newK, dungeons, visited);
                visited[j] = false;
            }
        }
        
        return maxDepth;
    }
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        int maxDepth = backTracking(0, 0, k, dungeons, visited);
        return maxDepth;
    }
}
