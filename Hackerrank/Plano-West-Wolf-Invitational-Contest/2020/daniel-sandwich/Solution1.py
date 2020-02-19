n = int(input())
ls = []
for i in range(n):
    ls.append(input())

dp = []
for i in range(n+1):
    dp.append([0]*(n+1))

for start in range(n-1, -1, -1):
    for end in range(start+1, n+1):
        dp[start][end] = 1 + dp[start+1][end]
        for k in range(start+1, end):
            if ls[start] == ls[k]:
                dp[start][end] = min(dp[start][end], dp[start+1][k] + dp[k][end])
print(dp[0][n])
"""
for i in dp:
    for j in i:
        print(j, end=" ")
    print()
"""
