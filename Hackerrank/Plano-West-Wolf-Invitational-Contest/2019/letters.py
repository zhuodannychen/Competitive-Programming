l = list(input().split())
inp = input()
flag = False
for i in range(1, int(l[0])+1):
    # print(inp)
    if l[i] in inp:
        inp = inp.replace(l[i], '')
    else:
        flag = True
        print('No, No, No!!!')
        break
if not flag:
    print('Potentially!')
