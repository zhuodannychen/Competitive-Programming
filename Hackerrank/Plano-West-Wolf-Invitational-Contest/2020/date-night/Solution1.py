l = list(map(int, input().split()))
m = 1
s = sum(l)
for i in range(10):
    m *= l[i]
print(f'{(m/s):.5f}')
