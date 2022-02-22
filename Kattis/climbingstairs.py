n, r, k = map(int, input().split())
ans = k # walk to office first
ones = max(0, (n - abs(r - k) - k + 1) // 2) # number of times to alternate
ans += ones*2 + abs(r-k) + r # alternation + dis from office to register to ground floor
print(ans)

