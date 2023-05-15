import math

s = input()
if len(s) < 10:
    num = 1
    product = 1
    while product != int(s):
        num += 1
        product *= num
    print(num)
else:
    num = 1
    ans = 1
    while math.floor(ans) != len(s):
        num += 1
        ans += math.log10(num)
    print(num)


