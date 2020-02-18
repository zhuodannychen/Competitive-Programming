n = int(input())
l = list(map(int, input().split()))
dp = [1] * n
for i in range(1, n):
    for j in range(i):
        if l[i] <= l[j]:
            dp[i] = max(dp[i], dp[j] + 1)
print(max(dp))
