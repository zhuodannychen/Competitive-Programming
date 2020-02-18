floors, elevators = map(int, input().split())
l = []
for i in range(elevators):
    a, b = map(int, input().split())
    l.append(2*a)
    l.append(2*b+1)
l.sort()
count = 0
flag = True
for i in l:
    if i % 2 == 0:
        count+=1
    else:
        count -= 1
    if count > 2:
        print('NO')
        flag = False
        break
if flag:
    print('YES')
