n = int(input())
for i in range(n):
    l = list(map(float, input().split()))
    p = l[0] - l[2]
    b = 2*l[0] - 2*p - l[1] + 1.25*p
    s = l[0] - p - b
    print(str(round(p)) + ' krabby patties, ' + str(round(b)) + ' coral bits, ' + str(round(s)) + ' kelp shakes')
