while True:
    n, b = map(int, input().split())
    if n == -1 and b == -1:
        break
    a = []
    low = 1
    high = 5000001
    for i in range(n):
        a.append(int(input()))
    input()
    while low < high:
        mid = low + (high - low) // 2
        cnt = 0
        for i in range(n):
            cnt += (a[i] + mid - 1) // mid
        if cnt > b:
            low = mid + 1
        else:
            high = mid
    print(low)
    
