a = list(input().split())
d = {}
for i in range(5):
    if a[i][0] not in d:
        d[a[i][0]] = 1
    else:
        d[a[i][0]] += 1
ans = 0
for item, val in d.items():
    ans = max(ans, val)
print(ans)


