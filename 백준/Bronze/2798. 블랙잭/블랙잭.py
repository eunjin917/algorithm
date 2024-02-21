from itertools import combinations as comb

N, M = map(int, input().split())
cards = list(map(int, input().split()))
cards.sort()

totals = set(sum(values) for values in comb(cards, 3))
sorted_totals = sorted(list(totals), reverse=True)
for total in sorted_totals:
    if total <= M:
        print(total)
        break