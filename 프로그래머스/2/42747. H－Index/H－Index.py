# 100,000,00 = 0.1초

def solution(citations):
    answer = 0
    citations.sort(reverse=True)    # 1000log1000
    for idx in range(len(citations)-1, -1, -1):   # 1~1000
        if citations[idx] >= idx+1:
            answer = idx+1
            break
    return answer

# n편 중 h이상인용 논문 = h개 이상
#       나머지 논문   = h개 이하
# h의 최대값 : 최대값부터 ...
# 6 5 3 1 0 -> 3
# h 5 -> 개수 2
# h 4 -> 개수 2
# h 2 -> 개수 3
# h <= 개수(인덱스)