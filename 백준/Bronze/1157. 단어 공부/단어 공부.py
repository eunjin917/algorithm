word = input()

word_dict = {}
for letter in word.upper():
    if letter in word_dict:
        word_dict[letter] += 1
    else:
        word_dict[letter] = 1

word_values = list(word_dict.values())
max_word_value = max(word_values)

if word_values.count(max_word_value) > 1:
    print("?")
else:
    for key, value in word_dict.items():
        if value == max_word_value:
            print(key)
