n = int(input())
arr = list(zip(list(map(int, input().split())), [x+1 for x in range(n)]))
arr.sort(reverse=True)
sm = 0
for i in range(1, n):
    sm += arr[i][0]

if arr[0][0] > sm:
    print("impossible")
else:
    for i in arr:
        print(i[1], end=" ")


