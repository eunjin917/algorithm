import sys

input = sys.stdin.readline
print = sys.stdout.write

words = set()

N = int(input())
for _ in range(N):
    words.add(input().rstrip())

sorted_words = sorted(list(words), key=lambda x: (len(x), x))
print("\n".join([word for word in sorted_words]))
