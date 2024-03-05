N, K = map(int, input().split())

arr = [n for n in range(1, N + 1)]

print("<", end="")

pointer = K - 1
for i in range(N - 1, 0, -1):
    print(arr[pointer], end=", ")
    del arr[pointer]
    pointer += K - 1
    pointer %= i
print(arr[pointer], end="")

print(">", end="")
