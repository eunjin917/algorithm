INF = float("inf")
X = int(input())

dp = [0] * (X + 1)
for i in range(2, X + 1):
    dp[i] = (
        min(
            dp[i - 1],
            (dp[i // 2] if i % 2 == 0 else INF),
            (dp[i // 3] if i % 3 == 0 else INF),
        )
        + 1
    )

print(dp[X])
