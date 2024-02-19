import sys

input = sys.stdin.readline
output = sys.stdout.write


def binary_search(num):
    left = 0
    right = N - 1

    while left <= right:
        mid = (left + right)//2
        if A[mid] == num:
            return 1
        elif A[mid] < num:
            left = mid + 1
        elif A[mid] > num:
            right = mid - 1
    return 0


N = int(input())
A = list(map(int, input().split()))
A.sort()

M = int(input())
nums = list(map(int, input().split()))

for num in nums:
    print(binary_search(num))