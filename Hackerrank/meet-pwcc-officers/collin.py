l = list(map(int, input().split()))
grid = []
for i in range(l[1]):
    grid.append(list(input()))
queue = [[0, 0]]
di = [0, 0]
dj = [-1, 1]
ans_flag = False
while len(queue) > 0:
    coord = queue.pop(0)
    grid[coord[0]][coord[1]] = 'V'
    if grid[coord[0]+1][coord[1]] != 'X':
        count = 0
        flag = 0
        while grid[coord[0]+count][coord[1]] != 'X':
            if count > l[2]:
                flag = 1
                break
            if coord[0] + count == l[1] - 1:
                flag = 2
                break
            count+=1
        if flag == 0:
            queue.append([coord[0]+count-1, coord[1]])
        elif flag == 1:
            continue
        else:
            ans_flag = True
            print('Yer boi done did it!')
            break
    else:
        for i in range(2):
            new_x = coord[0]
            new_y = dj[i] + coord[1]
            if new_y < 0 or new_y >= l[0] or grid[new_x][new_y] == 'X' or grid[new_x][new_y] == 'V':
                continue
            queue.append([new_x, new_y])
if not ans_flag:
    print("That's a josh situation.")

