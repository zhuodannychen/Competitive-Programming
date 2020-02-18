n, k = map(int, input().split())
l = sorted(list(map(int, input().split())), reverse=True)
ans = 0
for i in range(0, len(l), k):
    ans += 2 * (l[i] - 1)
print(ans)
