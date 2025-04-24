# 정의 + 입력
N, K = map(int, input().split())
A = list(map(int, input().split()))

# 계산
A.sort()

# 출력
print(A[K - 1])