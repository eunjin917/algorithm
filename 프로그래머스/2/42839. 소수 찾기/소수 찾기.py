from itertools import permutations
from math import isqrt

def isPrime(perm):
    if perm <= 1:
        return False
    for divisor in range(2, isqrt(perm)+1):
        if perm%divisor == 0:
            return False
    return True

def solution(numbers):
    # 순열 조합
    set_perms = set()
    for k in range(len(numbers)):   # P(7,1) + ... P(7,7)
        perms = permutations(numbers, k+1)
        for perm in perms:
            set_perms.add(int("".join(perm)))
    # 소수 확인
    answer = sum(1 for perm in set_perms if isPrime(perm))
    return answer