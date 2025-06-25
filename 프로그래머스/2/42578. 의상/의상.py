from collections import defaultdict
from math import prod

def solution(clothes):
    dict_cloths = defaultdict(list)
    for cloth, kind in clothes:
        dict_cloths[kind].append(cloth)
        
    answer = prod(len(value) + 1 for value in dict_cloths.values()) - 1
    return answer