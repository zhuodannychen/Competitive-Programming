l = list(input())
change = []
check = ['B', 'L', 'R']
if len(l) < 3:
    change = l

if len(l) >= 3:
    i = 0
    while i < len(l): 
        if sorted(l[i:i+3]) == check:
            change.append('C')
            i += 3
        else:
            change.append(l[i])
            i += 1
for i in range(len(change)):
    if change[i] == 'R':
        change[i] = 'S'
    elif change[i] == 'B':
        change[i] = 'K'
    elif change[i] == 'L':
        change[i] = 'H'
print(''.join(change))


    
