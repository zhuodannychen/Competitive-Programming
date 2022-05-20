l, m = map(int, input().split())
L, M = map(int, input().split())
t1, t2 = map(int, input().split())

tl1 = abs(l) + abs(L-l)
tm1 = abs(l) + abs(L-l) + abs(L-m) + abs(M-m)

tm2 = abs(m) + abs(M-m)
tl2 = abs(m) + abs(M-m) + abs(M-l) + abs(l-L)

tl3 = abs(l) + abs(m-l) + abs(M-m) + abs(M-m) + abs(m-L)
tm3 = abs(l) + abs(m-l) + abs(M-m)

tm4 = abs(m) + abs(m-l) + abs(l-L) + abs(L-l) + abs(l-M)
tl4 = abs(m) + abs(m-l) + abs(l-L)

if (tl1 <= t1 and tm1 <= t2) or (tl2 <= t1 and tm2 <= t2) or (tl3 <= t1 and tm3 <= t2) or (tl4 <= t1 and tm4 <= t2):
    print('possible')
else:
    print('impossible')

