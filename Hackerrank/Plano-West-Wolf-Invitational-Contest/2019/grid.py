def getComb(N):
    ans = 0
    for i in range(1, int(pow(N, 0.5)) + 1):
        if N % i == 0 and i*i != N:
            ans+=2
        elif i*i == N:
            ans+=1
    return ans

dp = [0]*(int(1e5)+1)
for i in range(1, len(dp)):
    dp[i] = dp[i-1] + getComb(i)
n = int(input())
for i in range(n):
    print(dp[int(input())])
