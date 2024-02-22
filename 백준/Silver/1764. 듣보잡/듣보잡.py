import sys

input = sys.stdin.readline
print = sys.stdout.write

N, M = map(int, input().split())

no_listens = set(input() for _ in range(N))
no_listen_and_sees = set()

for _ in range(M):
    noSee = input()
    if noSee in no_listens:
        no_listen_and_sees.add(noSee)

print(str(len(no_listen_and_sees)) + "\n")
print("".join(sorted(no_listen_and_sees)))
