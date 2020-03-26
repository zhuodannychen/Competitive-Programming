import math


for cases in range(int(input())):
    n, k = map(int, input().split())
    l = list(map(int, input().split()))

    left = 1
    right = l[-1] - l[0]
    while left < right:
        mid = (left + right) // 2
        k2 = 0
        for i in range(1, n):
            diff = l[i] - l[i-1]
            k2 += math.ceil(diff/mid) - 1
        if k2 > k:
            left = mid + 1
        else:
            right = mid
    print('Case #{}: {}'.format(cases + 1, left))
