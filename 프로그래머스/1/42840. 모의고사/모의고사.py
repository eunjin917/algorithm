def solution(answers):
    methods = [
        [1, 2, 3, 4, 5],
        [2, 1, 2, 3, 2, 4, 2, 5],
        [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    ]
    divisors = [5, 8, 10]
    scores = [0, 0, 0]
    
    for i, answer in enumerate(answers):  # 10000
        for j, divisor in enumerate(divisors):
            if answer == methods[j][i%divisor]:
                scores[j] += 1
                
    max_score = max(scores)
    answer = []
    
    for i, score in enumerate(scores):
        if score == max_score:
            answer.append(i+1)
    return answer