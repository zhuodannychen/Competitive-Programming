n = int(input())
l = sorted(list(map(int, input().split())))
ans = [[l[0]]]
for i in range(1, n):
    if l[i-1]+1 == l[i]:
        ans[-1].append(l[i])
    else:
        ans.append([l[i]])
for i in range(len(ans)):
    if len(ans[i]) > 2:
        print(str(ans[i][0]) + '-' + str(ans[i][-1]), end=' ')
    else:
        for j in ans[i]:
            print(j, end=' ')
