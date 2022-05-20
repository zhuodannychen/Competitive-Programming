import math

    
# dot product to find angle given 3 points
def angle(u, v, w):
    # form vectors
    x1 = u[0] - v[0]
    y1 = u[1] - v[1]
    x2 = w[0] - v[0]
    y2 = w[1] - v[1]
    return math.acos((x1*x2 + y1*y2) / (math.sqrt(x1**2 + y1**2) * math.sqrt(x2**2 + y2**2)))

def update(pts):
    n = len(pts)
    angles = []

    for i in range(len(formatpts)):
        x = [formatpts[i-1][0], formatpts[i-1][1]]
        y = [formatpts[i][0], formatpts[i][1]]
        z = [formatpts[(i+1)%n][0], formatpts[(i+1)%n][1]]
        angles.append(angle(x, y, z))
    return angles

while True:
    pts = list(map(int, input().split()))
    if len(pts) == 1:
        break
    formatpts = []
    for i in range(1, len(pts), 2):
        formatpts.append([pts[i], pts[i+1]])

    angles = update(formatpts)
    prevpt = [0, 0]
    prevmin = 0
    prevminidx = 0

    while True:
        mincost = 1000000000
        minidx = 0
        for i in range(len(angles)):
            if angles[i] < mincost:
                mincost = angles[i]
                minidx = i

        if prevmin > mincost:
            # triangles are getting sharper!
            formatpts.insert(prevminidx, prevpt)
            break
        if len(angles) == 3:
            # already a triangle
            break

        prevmin = mincost
        prevminidx = minidx
        prevpt[0] = formatpts[minidx][0]
        prevpt[1] = formatpts[minidx][1]
        del formatpts[minidx]
        angles = update(formatpts)

    print(len(formatpts), end=' ')
    for pt in formatpts:
        print(*pt, end=' ')
    print()
