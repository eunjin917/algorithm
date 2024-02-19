T = int(input())
for T in range(T):
    count = 0
    line = input()
    line += '\n'
    for c in line:
        if (c=='('):
            count += 1
        elif (c==')'):
            count -= 1
        elif (c=='\n'):
            if (count == 0):
                print('YES')
                break
            else:
                print('NO')
                break
        if (count < 0):
            print('NO')
            break