# 스택
# https://www.acmicpc.net/problem/10828
# 2021.01.08
# 1try : 시간초과
# 2try : sys.stdin.readline 사용 해결

import sys
input = sys.stdin.readline

def push(stack, X):
    stack.append(X)
    return stack

def pop(stack):
    if len(stack) == 0:
        print(-1)
    else:
        temp = stack[-1]
        del stack[-1]
        print(temp)
    return stack
    
def size(stack):
    print(len(stack))
    
def empty(stacK):
    if len(stack) == 0:
        print(1)
    else:
        print(0)
    
def top(stack):
    if len(stack) == 0:
        print(-1)
    else:
        print(stack[-1])



N = int(input()) # 명령의 수
stack = []

for i in range(N):
    s = input().strip().split() # 명령 입력
    if s[0] == "push":
        stack = push(stack, int(s[1]))
    elif s[0] == "pop":
        stack = pop(stack)
    elif s[0] == "size":
        size(stack)
    elif s[0] == "empty":
        empty(stack)
    elif s[0] == "top":
        top(stack)