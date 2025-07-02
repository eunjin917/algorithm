def dfs(idx, result, numbers, target):
    if idx == len(numbers):
        return 1 if result == target else 0
    return (dfs(idx+1, result+numbers[idx], numbers, target)
            + dfs(idx+1, result-numbers[idx], numbers, target))

def solution(numbers, target):
    answer = dfs(0, 0, numbers, target)
    return answer