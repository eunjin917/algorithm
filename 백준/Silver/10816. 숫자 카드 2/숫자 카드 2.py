import sys

input = sys.stdin.readline
print = sys.stdout.write

N = int(input())
cards = list(map(int, input().split()))
M = int(input())
find_cards = list(map(int, input().split()))

count_cards = {}

for card in cards:
    if card in count_cards.keys():
        count_cards[card] += 1
    else:
        count_cards[card] = 1

print(
    " ".join(
        [
            str(count_cards[find_card]) if (find_card in count_cards.keys()) else "0"
            for find_card in find_cards
        ]
    )
)
