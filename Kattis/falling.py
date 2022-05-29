n = int(input())
good = False
ans = 0
for i in range(200000):
    a = (i * i) - n
    if a < 0:
        continue
    b = int(a ** .5)
    if b * b == a:
        good = True
        ans = (str(b), str(i))
        break
print(' '.join(ans) if good else 'impossible')
