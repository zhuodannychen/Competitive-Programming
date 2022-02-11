n = int(input())
heights = list(map(int, input().split()))
mxLeft = [0 for x in range(n)]
mxRight = [0 for x in range(n)]

mxLeft[0] = heights[0]
for i in range(n):
    mxLeft[i] = max(mxLeft[i-1], heights[i])
mxRight[-1] = heights[-1]
for i in range(n-2, -1, -1):
    mxRight[i] = max(mxRight[i+1], heights[i])

ans = 0
for i in range(n):
    ans = max(ans, min(mxLeft[i], mxRight[i]) - heights[i])
print(ans)


