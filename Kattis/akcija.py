n = int(input())
books = []
for i in range(n):
    books.append(int(input()))
books.sort(reverse=True)
ans = 0
idx = 0
while idx < n:
    if (idx+1) % 3 != 0:
        ans += books[idx]
    idx += 1
print(ans)




