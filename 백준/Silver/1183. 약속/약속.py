# 정의
N = int(input())
times = []

# 입력
for i in range(N):
    A, B = map(int, input().split())
    times.append(A - B)
times.sort()

# 계산 + 출력
if N % 2 == 0:  # 중앙값 길이 출력
    midian_start = times[(N // 2) - 1]
    midian_end = times[N // 2]
    print(midian_end - midian_start + 1)
else:
    print(1)