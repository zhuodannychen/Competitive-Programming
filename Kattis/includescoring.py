import math

n = int(input())
teams = []
onsite = []
scores = [100, 75, 60, 50, 45, 40, 36, 32, 29, 26, 24, 22, 20, 18, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
scores += [0 for i in range(1001)]
for i in range(n):
    a, b, c, d = map(int, input().split())
    teams.append([a, b, c, i])
    onsite.append(d)
teams.sort(key=lambda x: (-x[0], x[1], x[2]))

left = 0
right = 1
while right < n:
    if teams[left][:3] == teams[right][:3]:
        right += 1
    else:
        avg = math.ceil(sum(scores[left:right]) / (right-left))
        for i in range(right-left):
            teams[i+left].append(avg)
        left = right
        right += 1

avg = math.ceil(sum(scores[left:right]) / (right-left))
for i in range(right-left):
    teams[i+left].append(avg)

teams.sort(key=lambda x: (x[3]))
for i in range(n):
    print(teams[i][4] + onsite[i])

