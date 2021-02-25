def binSearch(intervals, startIdx):
    left = 0
    right = startIdx - 1
    while left <= right:
        mid = left + (right - left) // 2
        if intervals[mid][1] < intervals[startIdx][0]:
            if intervals[mid+1][1] < intervals[startIdx][0]:
                left = mid+1
            else:
                return mid
        else:
            right = mid-1
    return -1


n, k = map(int, input().split())
intervals = []
for i in range(k):
    a, b = map(int, input().split())
    intervals.append([a, b, b-a+1])
intervals = sorted(intervals, key=lambda x:x[1])

dp = [0 for x in range(k)]
dp[0] = intervals[0][2]

for i in range(1, k):
    lastIdx = binSearch(intervals, i)
    if lastIdx != -1:
        dp[i] = max(dp[i-1], dp[lastIdx] + intervals[i][2])
    else:
        dp[i] = max(dp[i-1], intervals[i][2])

print(n - dp[k-1])


