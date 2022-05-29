n, m = map(int, input().split())
total, excess = 0, m-(n-1)
i, skips = 1, 0

while i <= m:
    total += i
    if excess > 0:
        i += min(excess, skips)
        excess -= skips
    else:
        total += (m*(m+1) - i*(i+1)) // 2
        break
    i += 1
    skips += 1
print(total)
