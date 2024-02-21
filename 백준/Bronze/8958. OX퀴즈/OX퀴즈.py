N = int(input())
for _ in range(N):
    testcase = input()

    O_flag = 0
    score = 0
    for problem in testcase:
        if problem == "O":
            O_flag += 1
            score += O_flag
        else:
            O_flag = 0
    print(score)
