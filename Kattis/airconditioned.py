n = int(input())
intervals = []
for i in range(n):
    interval = list(map(int, input().split()))
    intervals.append(interval)
intervals.sort()

ans = 1
cur = [intervals[0][0], intervals[0][1]]
for i in range(1, n):
    # overlap
    if intervals[i][0] <= cur[1]:
        cur[0] = intervals[i][0]
        cur[1] = min(cur[1], intervals[i][1])
    else:
        cur[0] = intervals[i][0]
        cur[1] = intervals[i][1]
        ans += 1
print(ans)
