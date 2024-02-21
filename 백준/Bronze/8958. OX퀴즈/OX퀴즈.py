N = int(input())
for _ in range(N):
    testcase = input()
    score = 0
    for idx, problem in enumerate(testcase):
        X_start = testcase.find("X", idx)
        end = X_start if X_start != -1 else len(testcase)
        score += testcase.count("O", idx, end)
    print(score)
