l, d, n = map(int, input().split())
# check small l
if l < 11:
    print(0)
    exit()
loc = [6]
for i in range(n):
    loc.append(int(input()))
loc.append(l-6)
loc.sort()
ans = 0
if len(loc) == 2:
    ans = (loc[1] - loc[0] + d) // d
else:
    for i in range(1, len(loc)):
        if i == 1:
            cur = (loc[i]-d - (loc[i-1]) + d) // d
        elif i == len(loc)-1:
            cur = (loc[i] - (loc[i-1]+d) + d) // d
        else:
            cur = (loc[i]-d - (loc[i-1]+d) + d) // d
        cur = max(cur, 0)
        # print(cur)
        ans += cur
# print(loc)
print(ans)
