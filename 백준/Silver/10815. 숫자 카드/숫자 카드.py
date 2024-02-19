def binary_search(value):
    left = 0
    right = N - 1
    while left <= right:
        mid = (left + right) // 2
        if value < cards[mid]:
            right = mid - 1
        elif value > cards[mid]:
            left = mid + 1
        else:
            return "1"
    return "0"


N = int(input())
cards = list(map(int, input().split()))
M = int(input())
values = list(map(int, input().split()))


cards.sort()

answer = [binary_search(value) for value in values]
print(" ".join(answer))