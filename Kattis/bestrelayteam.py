n = int(input())
runners = []
for i in range(n):
    a, b, c = list(input().split())
    b = float(b)
    c = float(c)
    runners.append([a, b, c])
runners.sort(key=lambda x: (x[2], x[1]))
time = 1000000000
select = [1,1,1,1]
ans = []

for i in range(n):
    cur = runners[i][1]
    select[0] = runners[i][0]
    cnt = 0
    for j in range(n):
        if cnt == 3:
            break
        if j != i:
            cur += runners[j][2]
            cnt += 1
            select[cnt] = runners[j][0]
    if cur < time:
        time = cur
        ans = list(select)

print(time)
for x in ans:
    print(x)

