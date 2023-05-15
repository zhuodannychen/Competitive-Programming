n = int(input())
letters = []
for i in range(n):
    letters.append(input())

ans = 0
for i in range(n-1, -1, -1):
    if letters[i] == 'O':
        ans += 1 << (n-i-1)
print(ans)
