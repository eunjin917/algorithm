N = int(input())
n_of_end = "666"
count = 0
num = 0
while True:
    if n_of_end in str(num):
        count += 1
    if count == N:
        break
    num += 1

print(num)
