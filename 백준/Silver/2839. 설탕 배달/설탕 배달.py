# 입력
N = int(input())

# 계산 : 그리디
# 5*i + 3*j = N -> 5*0 + 3*3 = 9
# i+j가 최소 -> 0+3 = 3
result = -1
i = N // 5  # 1 = 9 // 5
while i >= 0:
    if (N - 5 * i) % 3 == 0:
        j = (N - 5 * i) // 3
        result = i + j
        break
    else:
        i -= 1

# 출력
print(result)