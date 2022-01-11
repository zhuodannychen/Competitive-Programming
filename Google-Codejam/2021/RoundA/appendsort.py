for t in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    ans = 0
    for i in range(1, n):
        cnt = 0
        while a[i] <= a[i-1]:
            a[i] *= 10
            cnt += 1
        if cnt > 1 and (a[i]//10) + 10**(cnt-1) - 1 > a[i-1]:
            a[i] = a[i-1] + 1
            cnt -= 1
        ans += cnt
    print(f'Case #{t+1}: ' + str(ans))

