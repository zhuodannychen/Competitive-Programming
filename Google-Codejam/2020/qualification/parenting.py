for i in range(1, int(input())+1):
    n = int(input())
    l = []
    for j in range(n):
        s, e = map(int, input().split())
        l.append([s, e, j, '_'])
    l.sort()

    cend = 0
    jend = 0
    bad = False
    for j in range(n):
        if cend <= l[j][0]:
            l[j][3] = 'C'
            cend = l[j][1]
        elif jend <= l[j][0]:
            l[j][3] = 'J'
            jend = l[j][1]
        else:
            bad = True
            break
    if bad:
        print('Case #{}: IMPOSSIBLE'.format(i), end="")
    else:
        print('Case #' + str(i) + ": ", end="")
        l = sorted(l, key=lambda x: x[2])
        for j in range(len(l)):
            print(l[j][3], end="")
    print()

