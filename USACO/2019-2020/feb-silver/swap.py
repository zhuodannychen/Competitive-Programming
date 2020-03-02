# binary exponentiation

def one_iter(from_org, to_new):
    from_org = [x - 1 for x in from_org]
    res = []
    for i in range(len(from_org)):
        res.append(to_new[from_org[i]])
    return res


f = open('swap.in', 'r')
inp = list(map(int, f.readline().split()))
ls = list(range(1, inp[0] + 1))
commands = []
for i in range(inp[1]):
    commands.append(list(map(int, f.readline().split())))
    ls[commands[i][0]-1:commands[i][1]] = ls[commands[i][0]-1:commands[i][1]][::-1]
k = inp[2]
res = list(range(1, inp[0]+1))
while k > 0:
    if k & 1:
        res = one_iter(res, ls)
    ls = one_iter(ls, ls)
    k = k >> 1
print(res)
o = open('swap.out', 'w')
o.write('\n'.join(map(str, res)))
o.close()
