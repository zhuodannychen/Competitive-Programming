a = list(input())
b = list(input())

start = 0
for i in range(min(len(a), len(b))):
    if a[i] != b[i]:
        break
    start+=1

enda = len(a)-1
endb = len(b)-1
while enda >= start and endb >= start:
    if a[enda] != b[endb]:
        break
    enda-=1
    endb-=1
print(endb - start + 1)


