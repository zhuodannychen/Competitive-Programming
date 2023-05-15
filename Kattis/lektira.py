word = list(input())
n = len(word)

ans = ['z' for x in range(n)]
for i in range(1, n):
    for j in range(i+1, n):
        # print(word[:i] , word[i:j] , word[j:])
        newword = word[:i][::-1] + word[i:j][::-1] + word[j:][::-1]
        ans = min(newword, ans)
print(''.join(ans))