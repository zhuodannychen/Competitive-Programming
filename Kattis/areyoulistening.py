cx, cy, n = map(int, input().split())
circles = []
for i in range(n):
    c = list(map(int, input().split()))
    circles.append(c)

low = 0
high = 4000
while low < high:
    radius = low + (high - low + 1) // 2
    cnt = 0
    for i in range(n):
        dist = (cx-circles[i][0])**2 + (cy-circles[i][1])**2
        if dist < (radius + circles[i][2])**2:
            cnt += 1
    if cnt < 3:
        low = radius
    else:
        high = radius - 1
print(low)



