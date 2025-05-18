# 입력
N = int(input())

# 계산 : DP
## 11 = 5 * 1 + 3 * 2
dp = [-1] * (N + 1)
for i in range(N // 5 + 1):   # N // 5 = 2 -> 0, 1
    for j in range(5):  # 0, 1, 2, 3, 4
        if 5 * i + 3 * j <= N:
            dp[5 * i + 3 * j] = i + j

print(dp[N])