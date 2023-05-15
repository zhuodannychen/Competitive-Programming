n = int(input())
for _ in range(n):
    inp = list(map(int, input().split()))
    k = inp[0]
    arr = inp[1:]
    ans = 0
    for i in range(1, 11):
        for j in range(i, 11):
            mn = min(arr[i:j+1])
            if mn > arr[i-1] and mn > arr[j+1]:
                ans += 1
    print(k, ans)

