import math
import sys
input()
l = list(map(int, input().split()))
maxx = max(l)
st = str(bin(maxx))
print(math.ceil(len(st[2:]) / 8))
