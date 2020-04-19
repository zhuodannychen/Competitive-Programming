for tc in range(1, int(input()) + 1):
    n, m = map(int, input().split())
    l = list(map(int, input().split()))[::-1]
    lowest = m
    for i in range(n):
        lowest = lowest - (lowest % l[i])
    print('Case #' + str(tc) + ': ' + str(lowest))

