n = int(input())
b1, b2 = map(float, input().split())
b2 = 24 - b2
l = []
for i in range(n):
    l.append(float(input()))
l = sorted(l, reverse=True)
flag = True
for i in l:
    if b1 < b2:
        if b1 - i >= 0:
            b1 -= i
        elif b2 - i >= 0:
            b2 -= i
        else:
            print('NO')
            flag = False
            break
    else:
        if b2 - i >= 0:
            b2 -= i
        elif b1 - i >= 0:
            b1 -= i
        else:
            print('NO')
            flag = False
            break
if flag:
    print("YES")
