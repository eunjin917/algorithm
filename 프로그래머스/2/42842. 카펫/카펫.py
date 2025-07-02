from math import isqrt

def solution(brown, yellow):
    answer = []
    for divisor in range(1, isqrt(yellow)+1):
        if yellow%divisor == 0:
            quotient = yellow//divisor
            if (quotient+divisor)*2 + 4 == brown:
                answer = [quotient+2, divisor+2]
                break
    return answer

# b >= y
# (2, 1) => 4 3
# (1, 24)
# 6 4 => a+1 * 2 + b+1 * 2 => 16 + 12 = 28

# 4*2 + 6*2  +4 = 8 12 4

# 30 => 5 6 => 5까지해야함.
# 36 = 6 6 => 6까지해야함