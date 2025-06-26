def solution(sizes):
    weights, heights = zip(*sizes)
    max_w, max_h = max(weights), max(heights)
    key_max = max(max_w, max_h)
    key_idx = 0 if max_w >= max_h else 1
    another_idx = 1 if key_idx == 0 else 0
    
    another_max = 1
    for size in sizes:
        if size[key_idx] < size[another_idx]:
            size[key_idx], size[another_idx] = size[another_idx], size[key_idx]
        if another_max < size[another_idx]:
            another_max = size[another_idx]
    answer = key_max * another_max
    return answer

#가로 x 세로
# 10,000

# 80 40
# 60 50
# 60 30
# 30 70

# 1. 최댓값
# 2. 10000
# 80 70
#   >   으로 맞추기

# 8 15  8 15
# 5 15  5 15
# 14 7  7 14
# 10 7  7 10
# 12 3  3 12
#   <   으로 맞추기