for tc in range(1, int(input()) + 1):
    n = int(input())
    l = list(map(int, input().split()))
    count = 0
    for i in range(1, n-1):
        if l[i] > l[i-1] and l[i] > l[i+1]:
            count+=1
    print('Case #' + str(tc) + ': ' + str(count))

