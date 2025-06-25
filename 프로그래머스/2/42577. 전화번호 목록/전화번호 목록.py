def solution(phone_book):
    phone_book.sort()
    
    answer = True
    for idx in range(len(phone_book)-1):
        phone = phone_book[idx]
        cut = len(phone)
        if phone == phone_book[idx+1][:cut]:
            answer = False
            break
    
    return answer

# 띄쓰 고려
# 2,000,000,0 = 0.2 + 1,000,000