# we just need to buy the cheapest houses

for i in range(int(input())):
    n, m = map(int, input().split())
    l = sorted(list(map(int, input().split())))
    sum = 0
    count = 0
    for e in l:
        if sum + e <= m:
            sum += e
            count += 1
    print("Case #{}: {}".format(i+1, count))
