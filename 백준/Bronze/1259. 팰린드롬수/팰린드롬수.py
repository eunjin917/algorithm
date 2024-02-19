def is_palindrome(word):
    len_word = len(word)
    for i in range(len_word // 2):
        if word[i] != word[(len_word - 1) - i]:
            return "no"
    return "yes"


while True:
    word = input()
    if word == "0":
        break
    print(is_palindrome(word))
