# 입력
N = int(input())

# 계산 : 그리디
##  5*i + 3*j = N -> 5*0 + 3*3 = 9
##  i+j가 최소 -> 0+3 = 3
result = -1
i = N // 5  # 1 = 9 // 5
while i >= 0:
    M = N - 5 * i
    if M % 3 == 0:
        j = M // 3
        result = i + j
        break
    i -= 1

# 출력
print(result)