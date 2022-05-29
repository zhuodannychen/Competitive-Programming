n, k = map(int, input().split())
legs = []
for i in range(k):
    legs.append(list(map(int, input().split())))
legs.sort(key=lambda x: x[1])
perm = [i for i in range(n)]
for i in range(k):
    perm[legs[i][0]], perm[legs[i][0]+1] = perm[legs[i][0]+1], perm[legs[i][0]]
ans = sorted(list(zip([i for i in range(n)], perm)), key=lambda x: x[1])
for i in range(n):
    print(ans[i][0], end=' ')


