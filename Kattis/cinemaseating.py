n, m = map(int, input().split())
booking = int(input())
grid = [[0 for x in range(n)] for y in range(m)]

for i in range(booking):
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    grid[a][b] = 1


dr = [0, 0, 1, -1, -1, -1, 1, 1]
dc = [1, -1, 0, 0, -1, 1, 1, -1]
cnts = [0 for i in range(9)]
for i in range(n):
    for j in range(m):
        if not grid[i][j]:
            continue
        neighbors = 0
        for k in range(8):
            newx = i + dr[k]
            newy = j + dc[k]
            if newx < 0 or newx >= n or newy < 0 or newy >= m or not grid[newx][newy]:
                continue
            neighbors += 1
        cnts[neighbors] += 1
print(*cnts)

