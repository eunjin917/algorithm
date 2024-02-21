import sys

input = sys.stdin.readline
print = sys.stdout.write

while True:
    testcase = list(map(int, input().split()))
    if testcase == [0, 0, 0]:
        break

    if sum([length**2 for length in testcase]) == 2 * max(testcase) ** 2:
        print("right\n")
    else:
        print("wrong\n")
