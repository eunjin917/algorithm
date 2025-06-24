# 50테케 * 100log100 = O(50,000)
import heapq

def solution(array, commands):
    answer = []
    
    # 50테케
    for start, end, index in commands:
        sub_array = array[start - 1 : end]  # 4번째부터 4번째까지 자르기 => [3:4] => 3
        answer.append(heapq.nsmallest(index, sub_array)[-1])    # k번째 수
        
    return answer