ops = 0
commands = []
start = [0, 0]
end = [0, 0]
left = 0
right = 0
down = 0
up = 0
while True:
    try:
        com = input()
        ops += 1
        commands.append(com)
        if com == 'down':
            end[1] -= 1
            if end[1] < down:
                down = end[1]
        if com == 'left':
            end[0] -= 1
            if end[0] < left:
                left = end[0]
                start[0] += 1
            
        if com == 'up':
            end[1] += 1
            if end[1] > up:
                up = end[1]
                start[1] += 1
        if com == 'right':
            end[0] += 1
            right = max(right, end[0])
    except:
        break

gridX = abs(right-left)+1
gridY = abs(up-down)+1
grid = [[' ' for x in range(gridX)] for y in range(gridY)]

grid[start[1]][start[0]] = 'S'
x = start[1]
y = start[0]
# print(gridX, gridY, grid, start, end)
for i in range(ops):
    if commands[i] == 'down':
        x += 1
    if commands[i] == 'left':
        y -= 1
    if commands[i] == 'up':
        x -= 1
    if commands[i] == 'right':
        y += 1
    grid[x][y] = '*'
    if i == ops-1:
        grid[x][y] = 'E'
grid[start[1]][start[0]] = 'S'

print('#'*(gridX+2))
for i in range(gridY):
    print('#', end='')
    for j in range(gridX):
        print(grid[i][j], end='')
    print('#')
print('#'*(gridX+2))


