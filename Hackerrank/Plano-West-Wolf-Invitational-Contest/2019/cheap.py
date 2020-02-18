# Kadane's Algorithm

n = int(input())
l = list(map(int, input().split()))

ans = 0
cur = 0
pre = l[0]
for i in range(1, n):
    cur = max(0, cur + 1 - abs(l[i] - pre))
    ans = max(ans, cur)
    pre = l[i]
print(ans+1)
