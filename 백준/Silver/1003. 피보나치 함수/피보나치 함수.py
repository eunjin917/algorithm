dp = [[0, 0]] * 41
dp[0], dp[1] = [1, 0], [0, 1]

for i in range(2, 41):
    prev_1, prev_2 = dp[i - 1], dp[i - 2]
    dp[i] = [prev_1[0] + prev_2[0], prev_1[1] + prev_2[1]]

T = int(input())
for _ in range(T):
    N = int(input())
    answer = map(str, dp[N])
    print(" ".join(answer))
