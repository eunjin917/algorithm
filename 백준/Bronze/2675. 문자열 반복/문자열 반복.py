T = int(input())
for _ in range(T):
    R, S = input().split()
    R = int(R)
    print("".join([(letter * R) for letter in S]))
