import bisect

n, m = map(int, input().split())
cans = []
for i in range(n):
    cans.append(int(input()))

cans.sort()
ans = 0
for i in range(m):
    need = int(input())
    idx = bisect.bisect_left(cans, need)
    ans += cans[idx] - need
print(ans)


