for _ in range(int(input())):
    m, s = map(int, input().split())
    l = list(map(int, input().split()))
    total_trees = [0] * (m)
    total_trees[0] = s
    sym_trees = [0] * (m)
    sym_trees[0] = s
    for i in range(1, m):
        for j in range(s):
            total_trees[i] += pow(total_trees[i-1], l[j])
            if l[j] % 2 == 0:
                sym_trees[i] += pow(total_trees[i-1], l[j]//2)
            else:
                sym_trees[i] += pow(total_trees[i-1], l[j]//2) * sym_trees[i-1]
    # print(total_trees)
    # print(sym_trees)
    print(((total_trees[m-1] - sym_trees[m-1]) // 2 + sym_trees[m-1]) % int(1e9+7))


"""
Patterns I found:
|      |    /\       /\     /\      /\
   2^1                 2^2  = 6
|      /\  | |      /\/\   |\ |    | /|
2      4   2 2      4  4   4  2    2 4
            4        16     8        8
2^1   2^2  2^2      2^4    2^3     2^3 = 42


Symmetrical trees:
|   |      |       |       /\         /\              /\    /\       /\         /\
|   |      /\      /\     /\/\       /\/\             ||    ||      /\/\       /\/\
|   /\     ||     /\/\   /\||/\     |/\/\|            ||   /\/\     ||||     /\/\/\/\

|   |     /\     /\
|   /\    ||    /\/\
2^0 * 2      2^1  = 4


Other patterns:
|       /\      /|\
3^1     3^2     3^3  = 39

|        /\
2^1     2^2    = 6

"""
