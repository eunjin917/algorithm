import math

N = int(input())
for i in range(int(math.log2(N)) + 2):
    if 2**i > N:
        print(2 * (N - 2 ** (i - 1)))
        break
    elif 2**i == N:
        print(N)
        break
