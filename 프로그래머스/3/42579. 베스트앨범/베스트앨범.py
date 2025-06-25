from collections import defaultdict

def solution(genres, plays):
    dict_genres = defaultdict(list)
    for idx, (genre, play) in enumerate(zip(genres, plays)):  # 1~10000
        dict_genres[genre].append((idx, play))
        
    plays_genres = list(dict_genres.values())
    for plays in plays_genres:    # 0~99
        plays.sort(key=lambda x:[-x[1], x[0]])    # 10000log10000
        plays.append(sum(play for _, play in plays))
    plays_genres.sort(key=lambda x:-x[-1])  #100log100
    
    answer = []
    for plays in plays_genres:    # 100
        for idx, play in enumerate(plays):
            if isinstance(play, tuple) and idx < 2:
                answer.append(play[0])
    return answer