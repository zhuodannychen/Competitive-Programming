n = int(input())
a = list(map(int, input().split()))
# mx = 2,2,3,4,7,7,7,8
# mn = 1,1,3,4,5,5,6,8
mx = [a[0]]
mn = [a[-1]]
for i in range(1, n):
    mx.append(max(mx[-1], a[i]))
for i in range(n-2, -1, -1):
    mn.append(min(mn[-1], a[i]))
mn = mn[::-1]
ans = 0
for i in range(n):
    if a[i] >= mx[i] and a[i] <= mn[i]:
        ans+=1
print(ans)
