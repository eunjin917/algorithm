import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        
        // 초기
        int first = arr[0];
        answer.add(first);
        
        // 이후
        for (int i=1; i<arr.length; i++) {
            if (first == arr[i]) continue;
            
            first = arr[i];
            answer.add(first);
        }

        return answer;
    }
}