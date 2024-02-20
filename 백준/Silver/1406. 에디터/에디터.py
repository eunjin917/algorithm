import sys

input = sys.stdin.readline
print = sys.stdout.write


class Editer:
    left_text = []
    right_reverse_text = []

    def __init__(self, init_text):
        self.left_text = list(init_text)

    def L(self):
        if len(self.left_text) > 0:
            back = self.left_text.pop()
            self.right_reverse_text.append(back)

    def D(self):
        if len(self.right_reverse_text) > 0:
            back = self.right_reverse_text.pop()
            self.left_text.append(back)

    def B(self):
        if len(self.left_text) > 0:
            self.left_text.pop()

    def P(self, char):
        self.left_text.append(char)

    def get_text(self):
        return "".join(self.left_text + self.right_reverse_text[::-1])


def execute(command):
    match command[0]:
        case "L":
            editer.L()
            return
        case "D":
            editer.D()
            return
        case "B":
            editer.B()
            return
        case "P":
            editer.P(command[1])
            return


init_text = input().rstrip()
M = int(input())

editer = Editer(init_text)

for _ in range(M):
    execute(input().split())

print(editer.get_text())
