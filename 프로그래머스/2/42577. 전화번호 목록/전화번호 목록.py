# 1,000,000 * 20

def solution(phone_book):
    set_phone_book = set(phone_book)
    
    answer = True
    for phone in phone_book:
        temp = ""
        for idx in range(len(phone)-1):
            temp += phone[idx]
            if temp in set_phone_book:
                answer = False
                break
    
    return answer