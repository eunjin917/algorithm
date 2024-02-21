N = int(input())

times = list(map(int, input().split()))
times.sort(reverse=True)
print(sum([(time * (idx + 1)) for idx, time in enumerate(times)]))
