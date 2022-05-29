n, m = map(int, input().split())
if n == 0:
    print(0)
arr = list(map(int, input().split()))
for i in range(n):
    arr[i] -= m

ans = arr[0]
prev = arr[0]

for i in range(1, n):
    prev = max(prev + arr[i], arr[i])
    ans = max(ans, prev)
print(ans)
