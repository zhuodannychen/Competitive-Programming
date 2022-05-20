class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y
    

def ccw(A,B,C):
    return (C.y-A.y) * (B.x-A.x) > (B.y-A.y) * (C.x-A.x)

# Return true if line segments AB and CD intersect
def intersect(A,B,C,D):
    return ccw(A,C,D) != ccw(B,C,D) and ccw(A,B,C) != ccw(A,B,D)


while True:
    n = int(input())
    if n == 0:
        break
    linesegs = []
    for i in range(n):
        pts = list(map(float, input().split()))
        linesegs.append([Point(pts[0], pts[1]), Point(pts[2], pts[3])])
    ans = 0
    for i in range(n):
        for j in range(i+1, n):
            if intersect(linesegs[i][0], linesegs[i][1], linesegs[j][0], linesegs[j][1]):
                for k in range(j+1, n):
                    if intersect(linesegs[i][0], linesegs[i][1], linesegs[k][0], linesegs[k][1]) and intersect(linesegs[j][0], linesegs[j][1], linesegs[k][0], linesegs[k][1]):
                        ans += 1
    print(ans)

