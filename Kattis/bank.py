n, m = map(int, input().split())
ppl = []
for i in range(n):
    ppl.append(list(map(int, input().split())))
# ppl.sort(lambda x: (x[1], -x[0]))
ppl.sort(reverse=True)

vis = [False for x in range(m)]
ans = 0
for i in range(n):
    idx = ppl[i][1]
    while idx >= 0 and vis[idx]:
        idx -= 1
    if idx != -1:
        vis[idx] = True
        ans += ppl[i][0]
print(ans)
