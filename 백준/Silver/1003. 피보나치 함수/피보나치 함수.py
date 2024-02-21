dp = [0] * 41
dp[0], dp[1] = [1, 0], [0, 1]

for i in range(2, 41):
    dp[i] = [dp[i - 1][0] + dp[i - 2][0], dp[i - 1][1] + dp[i - 2][1]]
    
    
T = int(input())
for _ in range(T):
    N = int(input())
    answer = map(str, dp[N])
    print(" ".join(answer))
