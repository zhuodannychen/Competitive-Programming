from collections import Counter
import sys
LINES = sys.stdin.read().splitlines()[::-1]
def input(): return LINES.pop()

n, t = map(int, input().split())
a = sorted(list(map(int, input().split())))

if t == 1:
    left = 0
    right = n-1
    while left < right:
        if a[left] + a[right] == 7777 and a[left] != a[right]:
            print('Yes')
            exit()
        if a[left] + a[right] > 7777:
            right -= 1
        else:
            left += 1
    print('No')
if t == 2:
    print('Unique' if len(set(a)) == len(a) else 'Contains duplicate')
if t == 3:
    cnt = Counter(a)
    print(cnt.most_common(1)[0][0] if cnt.most_common(1)[0][1] > n/2 else -1)
if t == 4:
    if n % 2 == 1:
        print(a[n//2])
    else:
        print(a[n//2-1], a[n//2])
if t == 5:
    for x in a:
        if x >= 100 and x <= 999:
            print(x, end=' ')

        


