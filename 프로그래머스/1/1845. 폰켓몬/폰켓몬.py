from collections import Counter

def solution(nums):
    N_2 = len(nums)/2
    counter_nums = Counter(nums)
    print(counter_nums)
    
    answer = 0
    if len(counter_nums.keys()) >= N_2:
        answer = N_2
    else:
        answer = len(counter_nums.keys())
    return answer