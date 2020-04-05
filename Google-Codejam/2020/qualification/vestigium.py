for i in range(1, int(input()) + 1):
    n = int(input())
    trace = 0
    grid = []
    for j in range(n):
        grid.append(list(map(int, input().split())))
    for j in range(n):
        for k in range(n):
            if j == k:
                trace += grid[j][k]
    row = 0
    for j in range(n):
        if len(set(grid[j])) == len(grid[j]):
            continue
        row += 1

    col = 0
    for k in range(n):
        cols = []
        for j in range(n):
            cols.append(grid[j][k])
        if len(set(cols)) == len(cols):
            continue
        col += 1
    print("Case #{}: {} {} {}".format(i, trace, row, col))

