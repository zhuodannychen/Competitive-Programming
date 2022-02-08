n = int(input())
a = list(map(int, input().split()))

stack = []
mnHeight = 10000000
mxHeight = -100
ans = 0

for i in range(n):
    mxHeight = max(mxHeight, a[i])
    if a[i] == mxHeight:
        currMin = 10000000
        currMax = -100
        stoppt = -1
        oriLen = len(stack)
        while len(stack) > 0:
            currMin = min(currMin, stack[-1])
            currMax = max(currMax, stack[-1])
            stack.pop()

        if oriLen >= 2:
            ans = max(ans, min(currMax, mxHeight) - currMin)

    stack.append(a[i]) 

currMin = 10000000
currMax = -100
while len(stack) > 0:
    curr = stack.pop()
    if curr >= currMax:
        if currMin != 10000000:
            ans = max(ans, currMax - currMin)
            currMin = 10000000
        currMax = curr
    else:
        currMin = min(currMin, curr)
    

print(ans)
    
