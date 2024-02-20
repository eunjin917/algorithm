import sys

input = sys.stdin.readline
print = sys.stdout.write

_ = input()
cards = set(input().split())
_ = input()
nums = input().split()

answers = ["1" if (num in cards) else "0" for num in nums]
print(" ".join(answers))
