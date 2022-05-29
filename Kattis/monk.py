def findDist(time, arr, totalDist, isDsc):
    curTime = 0
    dist = 0
    for interval in arr:
        if curTime + interval[1] <= time:
            dist += interval[0]
            curTime += interval[1]
        else:
            unitDist = interval[0]/interval[1]
            dist += unitDist * (time-curTime)
            break
    return totalDist - dist if isDsc else dist


nasc, ndsc = map(int, input().split())
asc = []
dsc = []
totalDist = 0
totalTime = 0
for i in range(nasc):
    asc.append(list(map(int, input().split())))
    totalDist += asc[i][0]
    totalTime += asc[i][1]
for i in range(ndsc):
    dsc.append(list(map(int, input().split())))

# print(findDist(3, asc, totalDist, False))

low = 0
high = totalTime
while high - low > 0.000001:
    mid = low + (high - low) / 2
    ascDist = findDist(mid, asc, totalDist, False) 
    dscDist = findDist(mid, dsc, totalDist, True)
    # print("Time", mid, "ascDist", ascDist, "dscDist", dscDist)
    if ascDist < dscDist:
        low = mid 
    else:
        high = mid

print(f"{low:.6f}")


