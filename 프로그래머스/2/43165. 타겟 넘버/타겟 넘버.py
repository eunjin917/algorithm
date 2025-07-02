from itertools import product

def solution(numbers, target):
    choices = [(number, -number) for number in numbers]
    candidates = product(*choices)
    answer = sum(1 for candidate in candidates if sum(candidate) == target)
    return answer