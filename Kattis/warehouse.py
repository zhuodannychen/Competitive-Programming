from collections import defaultdict

tc = int(input())
for t in range(tc):
    vals = []
    n = int(input())
    toys = defaultdict(int)
    for i in range(n):
        val = list(input().split())
        val[1] = int(val[1])
        toys[val[0]] += val[1]
    for k, v in toys.items():
        vals.append([k, v])
    vals.sort(key=lambda x: (-x[1], x[0]))
    print(len(vals))
    for x in vals:
        print(x[0], x[1])


