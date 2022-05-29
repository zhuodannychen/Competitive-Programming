import math


for _ in range(int(input())):
    inp = list(map(int, input().split()))
    pts = []
    polar = []
    centerx = 0
    centery = 0
    for i in range(1, 2*inp[0], 2):
        pts.append([inp[i], inp[i+1]])
        centerx += inp[i]
        centery += inp[i+1]

    # find center of mass
    centerx /= inp[0]
    centery /= inp[0]

    for i in range(inp[0]):
        newx = pts[i][0]-centerx
        newy = pts[i][1]-centery
        polar.append([math.atan2(newy, newx), newx**2 + newy**2, i])

    polar.sort()
    for val in polar:
        print(val[2], end=' ')
    print()

