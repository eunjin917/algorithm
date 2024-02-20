import sys

input = sys.stdin.readline
print = sys.stdout.write

N = int(input())
A = list(map(int, input().rstrip().split()))
B = list(map(int, input().rstrip().split()))

A.sort(reverse=True)
B.sort()
print(str(sum((a * b) for a, b in zip(A, B))))
