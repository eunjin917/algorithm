import sys

input = sys.stdin.readline
print = sys.stdout.write

N = int(input())
cards = input().split()
M = int(input())
find_cards = input().split()

count_cards = {}

for card in cards:
    if card in count_cards:
        count_cards[card] += 1
    else:
        count_cards[card] = 1

print(" ".join([str(count_cards.get(find_card, 0)) for find_card in find_cards]))
