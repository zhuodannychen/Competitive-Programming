import math

def f(mid):
    dist = 0
    for i in range(n):
        dist = max((mid-coords[i][0])**2 + coords[i][1]**2, dist)
    return dist

while True:
    n = int(input())
    if n == 0:
        exit()
    coords = [[0,0] for x in range(n)]
    for i in range(n):
        x, y = map(float, input().split());
        coords[i][0] = x
        coords[i][1] = y

    low = -200000
    high = 200000
    while high - low > 0.000001:
        m1 = low + (high - low) / 3
        m2 = high - (high - low) / 3
        f1 = f(m1)
        f2 = f(m2)
        if f1 < f2:
            high = m2
        else:
            low = m1
    print(low, math.sqrt(f(low)))
    input()

