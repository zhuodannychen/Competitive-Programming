def rotate(grid):
    for i in range(n):
        for j in range(i+1, n):
            grid[i][j], grid[j][i] = grid[j][i], grid[i][j]

    for i in range(n):
        grid[i].reverse()


n = int(input())
grid = []
ans = [['' for x in range(n)] for y in range(n)]
for i in range(n):
    grid.append(list(input()))
decrypt = list(input())

rotations = 0
letter = 0
while rotations < 4:
    for i in range(n):
        for j in range(n):
            if grid[i][j] == '.':
                if ans[i][j] == '':
                    ans[i][j] = decrypt[letter]
                    letter += 1
                else:
                    print('invalid grille')
                    exit()
    rotations += 1
    rotate(grid)

for i in range(n):
    for j in range(n):
        if ans[i][j] == '':
            print('invalid grille')
            exit()
            
for i in range(n):
    for j in range(n):
        print(ans[i][j], end='')

