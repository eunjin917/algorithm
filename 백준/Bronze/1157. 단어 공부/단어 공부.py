from collections import Counter

word = input()
word_dict = Counter(word.upper())

max_word_value = max(word_dict.values())
max_word_keys = [key for key, value in word_dict.items() if value == max_word_value]

print(max_word_keys[0] if len(max_word_keys) == 1 else "?")
