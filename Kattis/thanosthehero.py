n = int(input())
worlds = list(map(int, input().split()))
ans = 0
for i in range(n-1, 0, -1):
    if worlds[i] <= worlds[i-1]:
        ans += worlds[i-1] - worlds[i] + 1
        worlds[i-1] = worlds[i]-1

if worlds[0] < 0:
    print(1)
else:
    print(ans)


