# 100,000,00 = 0.1초

def solution(citations):
    answer = 0
    citations.sort(reverse=True)    # 1000log1000
    for idx in range(len(citations)-1, -1, -1):   # 1000~1
        if citations[idx] >= idx+1:
            answer = idx+1
            return answer
    return 0    # [0, 0, 0]