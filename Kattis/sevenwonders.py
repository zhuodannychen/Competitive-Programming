from collections import Counter
s = input()

cnts = Counter(s)
mn = 1000000000
ans = 0
for k, v in cnts.items():
    mn = min(mn, v)
    ans += v**2

if len(cnts) == 3:
    ans += 7 * mn
print(ans)

