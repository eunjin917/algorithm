import sys

input = sys.stdin.readline
print = sys.stdout.write


class Queue:
    arr = []

    def push(self, X):
        self.arr.append(X)
        return

    def pop(self):
        front = self.front()
        if front == "-1":
            return "-1"
        del self.arr[0]
        return front

    def size(self):
        return str(len(self.arr))

    def empty(self):
        return "1" if self.size() == "0" else "0"

    def front(self):
        if self.empty() == "1":
            return "-1"
        return self.arr[0]

    def back(self):
        if self.empty() == "1":
            return "-1"
        return self.arr[-1]


def execute(command, queue):
    match command[0]:
        case "push":
            return queue.push(command[1])
        case "pop":
            return queue.pop()
        case "size":
            return queue.size()
        case "empty":
            return queue.empty()
        case "front":
            return queue.front()
        case "back":
            return queue.back()


N = int(input())
queue = Queue()


for _ in range(N):
    result = execute(input().split(), queue)
    if result != None:
        print(result + "\n")
