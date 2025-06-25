from functools import cmp_to_key

def comparator(x, y):
    if x + y > y + x:
        return -1
    elif x + y < y + x:
        return 1
    else:
        return 0

def solution(numbers):
    strings = list(map(str, numbers))    
    strings.sort(key=cmp_to_key(comparator))
    answer = "".join(strings) if strings[0] != "0" else "0"
    return answer