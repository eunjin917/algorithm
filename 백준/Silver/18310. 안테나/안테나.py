# 정의 + 입력
N = int(input())
houses = list(map(int, input().split()))
houses.sort()

# 계산 + 출력
if N % 2 == 0:
    print(houses[(N // 2) - 1])
else:
    print(houses[N // 2])