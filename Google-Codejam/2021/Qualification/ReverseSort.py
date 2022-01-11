for t in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    cost = 0
    for i in range(n-1):
        minE = a[i]
        minIdx = i
        for j in range(i, n):
            if a[j] < minE:
                minE = a[j]
                minIdx = j
        cost += minIdx - i + 1
        rev = a[i:minIdx+1][::-1]
        a = a[:i] + rev + a[minIdx+1:]
    print('Case #' + str(t+1) + ': ' + str(cost))

