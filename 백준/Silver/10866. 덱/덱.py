import sys
input = sys.stdin.readline
output = sys.stdout.write

class Deque:
    arr = []

    def push_front(self, N):
        self.arr.insert(0, N)

    def push_back(self, N):
        self.arr.append(N)

    def pop_front(self):
        front = self.front()
        if front == -1:
            return -1
        del self.arr[0]
        return front

    def pop_back(self):
        back = self.back()
        if back == -1:
            return -1
        del self.arr[-1]
        return back

    def size(self):
        return len(self.arr)

    def empty(self):
        return 1 if self.size() == 0 else 0

    def front(self):
        if self.empty():
            return -1
        return self.arr[0]

    def back(self):
        if self.empty():
            return -1
        return self.arr[-1]


def execute(deque, command):
    if command.startswith("push_back"):
        _, number = command.split()
        return deque.push_back(number)
    elif command.startswith("push_front"):
        _, number = command.split()
        return deque.push_front(number)

    match command:
        case "pop_front":
            return deque.pop_front()
        case "pop_back":
            return deque.pop_back()
        case "size":
            return deque.size()
        case "empty":
            return deque.empty()
        case "front":
            return deque.front()
        case "back":
            return deque.back()


N = int(input())
deque = Deque()
for _ in range(N):
    result = execute(deque, input().rstrip())
    if result != None:
        print(result)
