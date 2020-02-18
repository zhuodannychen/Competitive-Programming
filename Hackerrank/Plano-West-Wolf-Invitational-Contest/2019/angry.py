n = int(input())
l = []
for i in range(n):
    inp = list(map(int, input().split()))
    l.append(inp[1]*20 + inp[0])
    l.append(inp[2]*20 + inp[0])
l.sort()

val = 0
ans = 0
last = 0
for i in range(2*n):
    species_type = l[i] % 20
    day_number = l[i] // 20
    if val != 0:
        ans += day_number - last
    val ^= (1 << species_type)
    last = day_number
print(ans)
