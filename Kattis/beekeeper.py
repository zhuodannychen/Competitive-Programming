vowels = ['a', 'e', 'i','o','u','y']
while True:
    tc = int(input())
    if tc == 0:
        break
    answord = input()
    ans = 0
    for i in range(len(answord)-1):
        if answord[i] == answord[i+1] and answord[i] in vowels:
            ans += 1
        
    for i in range(tc-1):
        word = input()
        cnt = 0
        for j in range(len(word)-1):
            if word[j] == word[j+1] and word[j] in vowels:
                cnt += 1
        if cnt > ans:
            ans = cnt
            answord = word
    print(answord)
            

