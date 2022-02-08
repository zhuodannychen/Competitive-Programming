import math

n, k = map(int, input().split())
intervals = [0 for x in range(200000)]
for i in range(n):
    a = int(input())
    intervals[a] += 1
    intervals[a+1000] -= 1

ans = 0
prefix = [0 for i in range(len(intervals)+1)]
for i in range(1, len(intervals)):
    prefix[i] = prefix[i-1] + intervals[i-1]

mx = max(prefix)
print(int(math.ceil(mx / k)))


