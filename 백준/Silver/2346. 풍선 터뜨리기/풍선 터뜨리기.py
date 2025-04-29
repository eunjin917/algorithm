from collections import deque

# 입력
N = int(input())
commands = list(map(int, input().split()))

# 정의
Q = deque(x for x in range(1, N+1))

for _ in range(N):
    this_number = Q.popleft()   # 풍선 제거
    print(this_number, end=" ")
    this_command = commands[this_number - 1]    # 종이 확인
    if this_command > 0:    # 종이만큼 이동
      Q.rotate(-this_command+1) # 왼쪽 회전 (음수)
    else:
      Q.rotate(-this_command)   # 오른쪽 회전 (양수)