from math import *


def integrate(N, a, b):
    def f(x):
        return atan(x) * log10(x) / (sqrt(sin(x)) * (x * x))

    h = float(b - a) / N
    s = f(a) / 2 + f(b) / 2
    for i in range(1, N):
        s += f(a + i * h)
    return int(s * h * 10000 + .5) / 10000


for i in range(int(input())):
    f = float(input())

    low = 1.0
    high = 3.1410
    calc = 0
    while calc != f:
        mid = (low + high) / 2
        calc = integrate(1000, 1, mid)
        if calc < f:
            low = mid
        else:
            high = mid
    while calc == f:
        mid -= 0.0001
        calc = integrate(1000, 1, mid)
    mid += 0.0001
    print(f'{mid:.4f}')
