# A+B - 4
# https://www.acmicpc.net/problem/10951
# 2021.01.08

while True:
    try:
        A, B = map(int, input().split())
        print(A+B)
    except EOFError:
        break