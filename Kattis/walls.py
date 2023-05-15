import math

x, y, n, r = map(int, input().split())
building = [[-x/2, 0], [x/2, 0], [0, y/2], [0, -y/2]]
reachable = [0 for x in range(n)]
for i in range(n):
    xx, yy = map(int, input().split())
    for j in range(4):
        dist = math.sqrt((xx - building[j][0])**2 + (yy - building[j][1])**2)
        if dist <= r:
            reachable[i] = (reachable[i] | (1<<j))

# print(reachable)
everything = 0
for i in range(n):
    everything |= reachable[i]
if everything != 15:
    print('Impossible')
    exit()

# check 1
for i in range(n):
    if reachable[i] == 15:
        print(1)
        exit()

# check 2
for i in range(n):
    for j in range(i+1, n):
        if (reachable[i] | reachable[j]) == 15:
            print(2)
            exit()
# check 3
for i in range(n):
    for j in range(i+1, n):
        for k in range(j+1, n):
            if (reachable[i] | reachable[j] | reachable[k]) == 15:
                print(3)
                exit()

print(4)






