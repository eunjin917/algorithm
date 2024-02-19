T = int(input())
for T in range(T):
    stack = []
    line = input()
    line += '\n'
    for c in line:
        if (c==' ' or c=='\n'):
            while stack:
                print(stack.pop(), end='')
            print(' ', end='')
        else:
            stack.append(c)
    print()