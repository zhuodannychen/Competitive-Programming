n, m = map(int, input().split())
hay = {}
for i in range(n):
    word, pts = input().split()
    pts = int(pts)
    hay[word] = pts

for i in range(m):
    ans = 0
    while True:
        line = list(input().split())
        if line == ['.']:
            break
        for word in line:
            if word in hay:
                ans += hay[word]
    print(ans)

