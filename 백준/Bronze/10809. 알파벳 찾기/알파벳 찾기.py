S = input()
print(" ".join([str(S.find(chr(i))) for i in range(ord("a"), ord("z") + 1)]))
