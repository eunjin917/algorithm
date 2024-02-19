def is_groupword(word):
    this_index = 0
    while(this_index < len(word)):
        this_count = word.count(word[this_index])
        for i in range(this_count):
            if word[this_index+i] != word[this_index]:
                return 0
        this_index += this_count
    return 1

N = int(input())
count = sum([is_groupword(input()) for _ in range(N)])
print(count)