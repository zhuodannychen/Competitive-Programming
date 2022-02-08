n = int(input())
for i in range(n):
    l = list(input())
    sq = 1
    while sq*sq < len(l):
        sq += 1
    grid = [['*' for x in range(sq)] for y in range(sq)]
    row = 0
    col = 0
    for i in range(len(l)):
        grid[row][col] = l[i]
        col += 1
        if col == sq:
            col = 0
            row += 1
    for j in range(sq):
        for i in range(sq-1, -1, -1):
            if grid[i][j] == '*':
                continue
            print(grid[i][j], end='')
    print()

