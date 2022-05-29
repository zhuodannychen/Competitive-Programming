n, k = map(int, input().split())
locs = []
for i in range(n):
    locs.append(list(map(int, input().split())))

ans = 0

# pos
if locs[n-1][0] > 0:
    ans += locs[n-1][0]*2
    idx = n-1
    currK = k
    while idx >= 0 and locs[idx][0] > 0:
        if currK < locs[idx][1]:
            locs[idx][1] -= currK
            currK = 0
        else:
            currK -= locs[idx][1]
            locs[idx][1] = 0

        if locs[idx][1] > 0:
            ans += locs[idx][0] * 2
            currK = k
        else:
            idx -= 1

# neg
if locs[0][0] < 0:
    ans += abs(locs[0][0]*2)
    idx = 0
    currK = k
    while idx < n and locs[idx][0] < 0:
        if currK < locs[idx][1]:
            locs[idx][1] -= currK
            currK = 0
        else:
            currK -= locs[idx][1]
            locs[idx][1] = 0

        if locs[idx][1] > 0:
            ans += abs(locs[idx][0] * 2)
            currK = k
        else:
            idx += 1
print(ans)
