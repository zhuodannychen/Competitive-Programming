n, m = map(int, input().split())
l = [0]
l += list(map(int, input().split()))
l.append(n)
ans = []
for i in range(len(l)):
    for j in range(i+1, len(l)):
        ans.append(l[j] - l[i])
ans.sort()
print(*set(ans))


