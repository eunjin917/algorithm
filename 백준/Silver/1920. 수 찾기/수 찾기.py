import sys

input = sys.stdin.readline
print = sys.stdout.write

_ = input()
A = set(input().split())
_ = input()
nums = input().split()

answers = ["1" if (num in A) else "0" for num in nums]
print("\n".join(answers))
