import sys

input = sys.stdin.readline
print = sys.stdout.write

N = int(input())

people = [([i] + input().split()) for i in range(N)]
people.sort(key=lambda x: (int(x[1]), x[0]))

print("\n".join([(" ".join(person[1:])) for person in people]))
