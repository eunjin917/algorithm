import sys
input = sys.stdin.readline
print = sys.stdout.write

N = int(input())
nums = [0]*10001    # 1 ~ 10000
for i in range(N):
    nums[int(input())] += 1
for i in range(10001):
    for _ in range(nums[i]):
        print(str(i)+'\n')