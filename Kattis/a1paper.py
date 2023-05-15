# a = (1/pow(2, 3/4))
# b = (1/pow(2, 5/4))
# c = (1/pow(2, 3/4))
# print(a+b+c)

sidea = 1/pow(2, 3/4)
sideb = 1/pow(2, 5/4)

def dfs(idx, need, sidea, sideb, n):
    if idx >= n-1:
        print('impossible')
        exit()
    if need - papers[idx] <= 0:
        if idx % 2 == 0:
            return sidea*need/2
        else:
            return sideb*need/2

    if idx % 2 == 0:
        return dfs(idx+1, 2*(need-papers[idx]), sidea/2, sideb, n) + sidea * need/2
    else:
        return dfs(idx+1, 2*(need-papers[idx]), sidea, sideb/2, n) + sideb * need/2


n = int(input())
papers = list(map(int, input().split()))

# print(sidea+sideb)
print(dfs(0, 2, sidea, sideb, n))
