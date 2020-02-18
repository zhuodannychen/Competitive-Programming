s = list(input().split(" "))
c = 0
for i in s:
    if i == 'not':
        c+=1
print('SAD') if c % 2 == 1 else print('LOVE')
