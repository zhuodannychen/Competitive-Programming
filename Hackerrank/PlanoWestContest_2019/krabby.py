l = list(map(int, input().split()))
total_age = l[1] * 365 + l[2]
group = []
for i in range(l[0]):
    inp = list(input().split())
    group.append(int(inp[1])*365 + int(inp[2]))
group = sorted(group, reverse=True)
ans = 0
while len(group) != 0:
    days_left = total_age - group[0]
    ans += days_left
    count = 2
    del group[0]
    while len(group) > 0 and count > 0:
        del group[len(group) - 1]
        count-=1
    for i in range(len(group)):
        group[i] += days_left

print(str(ans // 365) + ' year(s) and ' + str(ans % 365) + ' day(s)')
