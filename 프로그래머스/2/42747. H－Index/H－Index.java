import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        Integer[] books = new Integer[n];
        for (int i=0; i<n; i++) {
            books[i] = citations[i];
        }
        Arrays.sort(books, (a, b)->b-a);
        
        // 1000번 * 10000번
        int answer = -1;
        for (int hIndex = books[0]; hIndex >=0; hIndex--) {
            int highCount = 0;
            int lowCount = 0;
            for (int j=0; j<n; j++) {
                if (books[j] >= hIndex) highCount++;
            }
            if (highCount >= hIndex) {
                answer = hIndex;
                break;
            }
        }
        
        return answer;
    }
}