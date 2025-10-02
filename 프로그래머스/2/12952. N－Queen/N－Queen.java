import java.util.*;

class Solution {
    static int n;
    static int answer;
    static boolean[] seros;
    static boolean[] lDegas;
    static boolean[] rDegas;
    
    public void dfs(int depth) {
        if (depth == n) {
            // 검증 다 된 상태
            answer++;
            return;
        }
        
        for (int i=0; i<n; i++) {
            //가로 세로 대각선 모두 해당X
            if (!seros[i] && !lDegas[i+depth] && !rDegas[i+n-depth-1]) {
                // true
                seros[i] = true;
                lDegas[i+depth] = true;
                rDegas[i+n-depth-1] = true;
                
                dfs(depth+1);
                
                // false
                seros[i] = false;
                lDegas[i+depth] = false;
                rDegas[i+n-depth-1] = false;
                
            }
        }
    }
    
    public int solution(int n) {
        this.n = n;
        this.answer = 0;
        this.seros = new boolean[n];
        this.lDegas = new boolean[2*n - 1];
        this.rDegas = new boolean[2*n - 1];
        
        dfs(0);
        
        return answer;
    }
}