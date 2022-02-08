tc = int(input())
for t in range(tc):
    blk = input()
    n, m = map(int, input().split())
    cs = list(map(int, input().split()))
    econ = list(map(int, input().split()))

    sumcs = sum(cs)
    avgcs = sumcs / n
    sumecon = sum(econ)
    avgecon = sumecon / m
    ans = 0
    for i in range(n):
        currcs = (sumcs - cs[i]) / (n-1)
        currecon = (sumecon + cs[i]) / (m+1)
        if currcs > avgcs and currecon > avgecon: 
            ans += 1
    print(ans)

    
