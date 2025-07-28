class Solution {
    static final char[] DICTIONARY = {'A', 'E', 'I', 'O', 'U'};
    static int count = 0;
    static int answer = 0;
    
    public void dfs(int depth, String current, String word) {
        if (depth > 5) {
            return;
        }
        
        count++;
        
        if (current.equals(word)) {
            answer = count;
            return;
        }

        for (int i=0; i<5; i++) {
            dfs(depth+1, current+DICTIONARY[i], word);
        }
    }
    
    public int solution(String word) {
        dfs(0, "", word);
        return answer-1;

    }
}
