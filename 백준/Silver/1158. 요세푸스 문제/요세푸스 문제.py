N, K = map(int, input().split())
people = [person for person in range(1, N + 1)]

order = []
idx = 0
for _ in range(N):
    idx += K - 1
    idx %= len(people)
    order.append(people[idx])
    del people[idx]

print("<" + ", ".join(str(person) for person in order) + ">")