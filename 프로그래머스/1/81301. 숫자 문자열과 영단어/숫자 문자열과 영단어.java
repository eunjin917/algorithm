import java.util.*;

class Solution {
    public int solution(String s) {
        // 사전
        Map<String, String> dict = new HashMap<>();
        dict.put("zero",  "0");
        dict.put("one",   "1");
        dict.put("two",   "2");
        dict.put("three", "3");
        dict.put("four",  "4");
        dict.put("five",  "5");
        dict.put("six",   "6");
        dict.put("seven", "7");
        dict.put("eight", "8");
        dict.put("nine",  "9");
        Set<Character> number = new HashSet<>();
        number.add('0');
        number.add('1');
        number.add('2');
        number.add('3');
        number.add('4');
        number.add('5');
        number.add('6');
        number.add('7');
        number.add('8');
        number.add('9');
        
        // 50번 : s 확인
        int n = s.length();
        StringBuilder answer = new StringBuilder();
        int startI = -1;
        int endI = -1;
        boolean ing = false;
        
        for (int i=0; i<n; i++)  {
            char a = s.charAt(i);
            if (number.contains(a)) {    // 숫자인 경우
                answer.append(a);
            } else {                        // 문자
                if (!ing) {
                    ing = true;
                    startI = i;
                    endI = i;
                }
                
                endI = i;
                String abc = s.substring(startI, endI+1);
                if (dict.get(abc) != null) {    // 여기까지가 단어인 경우
                    answer.append(dict.get(abc));
                    startI = -1;
                    endI = -1;
                    ing = false;
                }
            }
        }
        
        return Integer.parseInt(answer.toString());
    }
}