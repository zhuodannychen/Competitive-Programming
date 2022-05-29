n, s = input().split()
n = int(n)
dic = []
for i in range(n):
    dic.append(list(input().split()))

dp = [0 for x in range(len(s)+1)]
dp[0] = 1
for i in range(1, len(s)+1):
    for j in range(i):
        for words in dic:
            if dp[j] and s[j:i] == words[0]:
                dp[i] += dp[j] * int(words[1]) % 1000000007
print(dp[len(s)] % 1000000007)
            
