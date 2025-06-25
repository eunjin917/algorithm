def solution(numbers):
    strings = list(map(str, numbers))    
    strings.sort(key=lambda x:x*3, reverse=True) # 길이가 짧은 것 먼저
    answer = "".join(strings) if strings[0] != "0" else "0"
    return answer