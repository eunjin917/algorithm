import java.util.*;

class Solution {
    
    class Plan {
        String name;
        int startTime;
        int playTime;
        
        Plan(String name, int startTime, int playTime) {
            this.name = name;
            this.startTime = startTime;
            this.playTime = playTime;
        }
        
        public String toString() {
            return name+" / "+startTime+" / "+playTime;
        }
    }
    

    public List<String> solution(String[][] plans) {
        // 시간순 정렬
        Arrays.sort(plans, (a, b)->a[1].compareTo(b[1]));
        // 초기화
        int n = plans.length;
        Plan[] planTasks = new Plan[n];
        for (int i=0; i<n; i++) {
            planTasks[i] = new Plan(plans[i][0], dateToInt(plans[i][1]), Integer.parseInt(plans[i][2]));
        }
        
        // 스택
        Stack<Plan> stack = new Stack<>();
        // 첫 초기화
        Plan beforePlan = planTasks[0];
        stack.push(beforePlan);
        
        List<String> answer = new ArrayList<>();
        for (int i=1; i<n; i++) {
            Plan curPlan = planTasks[i];
            
            // System.out.println(answer+"///. "+Arrays.toString(stack.toArray()));
            
            // 이 시간 이전을 확인
            int remain = curPlan.startTime - beforePlan.startTime;
            while (!stack.isEmpty() && remain > 0) {    // 더 불가X
                Plan ingTask = stack.peek();
                // System.out.println("--"+ingTask);
                if (ingTask.playTime <= remain) {       // 완전 끝낼 수 있음
                    stack.pop();
                    remain -= ingTask.playTime;
                    answer.add(ingTask.name);
                } else if (ingTask.playTime > remain) { // 일부만 끝내기
                    ingTask.playTime -= remain;
                    remain = 0;
                }
            }
            
            // 이 순간 과제 추가
            stack.push(planTasks[i]);
                        
            // 업뎃
            beforePlan = curPlan;
        }
        
        // 마지막 이후 과제를 확인
        while (!stack.isEmpty()) {
            Plan ingTask = stack.pop();
            answer.add(ingTask.name);
        }
        
        return answer;
    }
    
    public int dateToInt(String date) {
        return Integer.parseInt(date.substring(0, 2))*60 + Integer.parseInt(date.substring(3, 5));
    }
}
