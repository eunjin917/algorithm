from collections import deque

line = input()
line += '\n'

deq = deque()
isTag = 0
for c in line:
    if (c == '<'):
        isTag = 1
        while(len(deq) != 0):
            print(deq.pop(), end='')
        print(c, end='')
        continue
    elif (c == '>'):
        isTag = 0
        while(len(deq) != 0):
            print(deq.popleft(), end='')
        print(c, end='')
        continue
    elif (isTag==0 and (c==' ' or c=='\n')):
        while(len(deq) != 0):
            print(deq.pop(), end='')
        print(c, end='')
        continue
    elif (isTag==1 and (c==' ' or c=='\n')):
        while(len(deq) != 0):
            print(deq.popleft(), end='')
        print(c, end='')
        continue
    
    deq.append(c)