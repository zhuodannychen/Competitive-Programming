n, k = map(int, input().split())
ans = n-1
if k >= n:
    print(ans)
    exit()
near = k
away = (n-1) // k * k
print(min(ans, n-1 - away + near+1))



