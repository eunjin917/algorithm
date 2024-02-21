A, B, C = [int(input()) for _ in range(3)]
result = str(A * B * C)
print("\n".join([str(result.count(str(i))) for i in range(9 + 1)]))
