n = int(input())
a = list(map(int, input().split()))

# 1 for odd, 0 for even
while True:
    comp = [[a[0] % 2]]
    for i in range(1, len(a)):
        if a[i] % 2 == a[i-1] % 2:
            comp[-1].append(a[i] % 2)
        else:
            comp.append([a[i] % 2])
    newcomp = []
    # fine
    for i in range(len(comp)):
        if len(comp[i]) % 2 == 1:
            newcomp.append(comp[i][0])
    a = newcomp
    good = False
    # fine
    for i in range(1, len(newcomp)):
        if newcomp[i] == newcomp[i-1]:
            good = True
            break
    if not good:
        break

print(len(a))



