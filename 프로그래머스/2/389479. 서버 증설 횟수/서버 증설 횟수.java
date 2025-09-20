import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int[] server = new int[24];
        int answer = 0;
        
        for (int i=0; i<24; i++) {
            int cur = players[i]/m;
             // System.out.println(cur);
            
            if (cur != 0 && server[i] < cur) {
                int need = cur - server[i];
                for (int j=0; j<k; j++) {
                    if (i+j < 24) {
                        server[i+j] += need;
                    }
                }
                
                answer += need;
            }
        }
        
        // System.out.println(Arrays.toString(server));
        return answer;
    }
}