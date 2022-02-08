n = int(input())
ans = 0
for i in range(n):
    s = input()
    lose = False
    for i in range(len(s)-1):
        if s[i] == 'C' and s[i+1] == 'D':
            lose = True
            break
    if not lose:
        ans += 1
print(ans)


