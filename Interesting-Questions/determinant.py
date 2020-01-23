"""
3
1 2 3
2 3 4
5 6 5
1 2 3 4
2 3 4 4
5 6 5 2
8 9 9 4
1 2 3 9 8 7
2 3 4 4 4 3
5 6 5 2 9 8
8 9 9 4 6 5
3 2 1 5 4 3
9 8 7 5 4 5
"""


def recurse(grid):
    ans = 0
    if len(grid) == 2:
        # print(grid[0][0] * grid[1][1] - grid[0][1] * grid[1][0])
        return grid[0][0] * grid[1][1] - grid[0][1] * grid[1][0]

    for i in range(len(grid)):
        temp = []
        for j in range(1, len(grid)):
            temp2 = []
            for k in range(len(grid)):
                if k != i:
                    temp2.append(grid[j][k])
            temp.append(temp2)
        # print(temp)
        if i % 2 == 0:
            ans += grid[0][i] * recurse(temp)
        else:
            ans -= grid[0][i] * recurse(temp)
    # print('answer', ans)
    return ans


for i in range(int(input())):
    ans = 0
    l = []
    first_l = list(map(int, input().split()))
    l.append(first_l)
    for j in range(1, len(first_l)):
        l.append(list(map(int, input().split())))
    print(recurse(l))
