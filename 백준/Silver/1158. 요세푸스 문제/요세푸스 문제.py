N, K = map(int, input().split())
people = [person for person in range(1, N + 1)]

order = []
next_idx = 0
for _ in range(N):
    this_idx = (next_idx + K - 1) % len(people)
    order.append(people[this_idx])
    del people[this_idx]
    next_idx = this_idx

print("<" + ", ".join(str(person) for person in order) + ">")