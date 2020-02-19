import math

n = int(input())
x1, y1 = map(int, input().split())
x2, y2 = map(int, input().split())
print(x1, y1)
print(x2, y2)
dist = math.sqrt((x2-x1) * (x2-x1) + (y2-y1) * (y2-y1))
angle = 180 - (n-2)*180/n
start_angle = 180/math.pi * math.atan2((y2-y1), (x2-x1))
# print(start_angle, angle)

for i in range(n-2):
    start_angle += angle
    x2 = x2 + dist*math.cos(math.pi/180 * start_angle)
    y2 = y2 + dist*math.sin(math.pi/180 * start_angle)
    print(f'{x2:.3f} {y2:.3f}')
