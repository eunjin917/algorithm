import sys

class Stack:
    def __init__(self):
        self.len = 0
        self.list = []

    def size(self):
        print(self.len)

    def push(self, X):
        self.list.append(X)
        self.len += 1

    def pop(self):
        if self.len == 0:
            print(-1)
        else:
            X = self.list[self.len-1]
            self.list.pop()
            self.len -= 1
            print(X)

    def empty(self):
        if self.len == 0:
            print(1)
        else:
            print(0)

    def top(self):
        if self.len == 0:
            print(-1)
        else:
            print(self.list[self.len-1])


N = int(input())
stack = Stack()
for line in sys.stdin:
    line_split = line.split()
    if line_split[0] == 'pop':
        stack.pop()
    elif line_split[0] == 'size':
        stack.size()
    elif line_split[0] == 'empty':
        stack.empty()
    elif line_split[0] == 'top':
        stack.top()
    elif line_split[0] == 'push':
        X = line_split[1]
        stack.push(X)