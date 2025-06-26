from collections import Counter
from math import prod

def solution(clothes):
    counter_cloths = Counter([kind for _, kind in clothes])
    print(counter_cloths)
    answer = prod(value+1 for value in counter_cloths.values()) - 1
    return answer