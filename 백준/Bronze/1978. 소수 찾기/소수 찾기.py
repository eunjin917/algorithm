_ = input()
nums = list(map(int, input().split()))

is_prime = [not any([(num % i == 0) for i in range(2, num)]) for num in nums if num != 1]
print(is_prime.count(True))
