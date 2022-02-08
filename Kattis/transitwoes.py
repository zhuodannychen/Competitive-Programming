s, t, n = map(int, input().split()) 
walk = list(map(int, input().split()))
bus = list(map(int, input().split()))
c = list(map(int, input().split()))
total = 0
ci = 0
bi = 0

for i in range(n):
    total += walk[i]
    total += 0 if (total % c[ci] == 0) else c[ci] - (total % c[ci])
    ci += 1
    total += bus[bi]
    bi += 1

print('no' if total+walk[-1] > t else 'yes')



