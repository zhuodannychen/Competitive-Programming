n, t = map(int, input().split())
a = list(map(int, input().split()))
if t == 1:
    print(7)
elif t == 2:
    if a[0] > a[1]:
        print('Bigger')
    elif a[0] == a[1]:
        print('Equal')
    else:
        print('Smaller')
elif t == 3:
    sub = sorted(a[:3])
    print(sub[1])
elif t == 4:
    print(sum(a))
elif t == 5:
    sm = 0
    for x in a:
        if x % 2 == 0:
            sm += x
    print(sm)
elif t == 6:
    for x in a:
        x %= 26
        print(chr(x+97), end='')
else:
    vis = [False for x in range(n)]
    i = 0
    while not vis[i]:
        vis[i] = True
        i = a[i]
        if i >= n:
            print('Out')
            exit()
        elif i == n-1:
            print('Done')
            exit()
    print('Cyclic')

