from collections import Counter

def solution(participant, completion):
    answer = ''
    
    counter_completion = Counter(completion)
    # 1~100,000
    for person in participant:
        if counter_completion[person] > 0:
            counter_completion[person] -= 1
        elif person not in counter_completion or counter_completion[person] == 0:
            answer = person
            break
      
    return answer