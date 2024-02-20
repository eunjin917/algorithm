import sys

input = sys.stdin.readline
print = sys.stdout.write

N = int(input())
points = []
for _ in range(N):
    points.append(tuple(map(int, input().split())))

points.sort()
print("\n".join([(str(x) + " " + str(y)) for x, y in points]))
