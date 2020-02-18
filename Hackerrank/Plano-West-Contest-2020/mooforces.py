n, m = map(int, input().split())
l = []
for i in range(n):
    l.append(list(input().split()))
l = sorted(l, key=lambda x: (-int(x[1]), int(x[2]), int(x[3]), x[0]))
for i in range(m):
    print(l[i][0])
