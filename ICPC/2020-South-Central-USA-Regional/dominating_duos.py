n = int(input())
stk = []
a = []
ans = 0
for i in range(n):
    a.append(int(input()))
for i in range(n):
    if len(stk) == 0:
        stk.append(a[i])
    elif a[i] < stk[-1]:
        stk.append(a[i])
    else:
        while a[i] > stk[-1] and len(stk) > 1:
            ans += 1
            stk.pop()
        if a[i] < stk[-1]:
            stk.append(a[i])
        else:
            stk[0] = a[i]
print(ans + n - 1) # add all pairs of length 2, and there are n-1 of them

