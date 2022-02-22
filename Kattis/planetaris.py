n, m = map(int, input().split())
solar = sorted(list(map(int, input().split())))
ans = 0
total = 0
idx = 0
while idx < n:
    if m - total - solar[idx]-1 >= 0:
        total += solar[idx]+1
        ans += 1
        idx += 1
    else:
        break
print(ans)

    

