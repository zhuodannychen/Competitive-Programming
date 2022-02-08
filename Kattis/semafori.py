n, d = map(int, input().split())
ans = 0
data = [[0,0,0]]
for i in range(n):
    data.append(list(map(int, input().split())))
for i in range(1, n+1):
    ans += data[i][0] - data[i-1][0]
    if ans % (data[i][1] + data[i][2]) < data[i][1]:
        ans += data[i][1] - (ans % (data[i][1] + data[i][2]))
    if i == n:
        ans += d - data[i][0]
print(ans)

    
    


