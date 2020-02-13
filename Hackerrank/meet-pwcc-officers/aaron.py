n = int(input())
grid = []
goal = []
for i in range(n):
    grid.append(list(input()))
input()
for i in range(n):
    goal.append(list(input()))
ans = 0
for i in range(n-2):
    for j in range(n-2):
        if grid[i][j] != goal[i][j]:
            ans += 1
            for k in range(3):
                for l in range(3):
                    grid[i+k][j+l] = 'X' if grid[i+k][j+l] == 'O' else 'O'
flag = True
for i in range(n):
    for j in range(n):
        if grid[i][j] != goal[i][j]:
            print('NO SOLUTION')
            flag = False
            break
    if not flag:
        break
if flag:
    print(ans)
