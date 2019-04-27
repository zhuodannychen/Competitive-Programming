n = int(input())
for i in range(n):
    l = list(input().split())
    l[0]=int(l[0])
    if l[1] == 'true':
        if l[0] <= 65:
            print('no ticket')
        elif l[0] >= 66 and l[0] <= 85:
            print('small ticket')
        else:
            print('big ticket')
    else:
        if l[0] <= 60:
            print('no ticket')
        elif l[0] >= 61 and l[0] <= 80:
            print('small ticket')
        else:
            print('big ticket')

