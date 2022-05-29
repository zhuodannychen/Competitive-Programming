n = int(input())
heights = sorted(list(map(int, input().split())))

ans = n
for i in range(n):
    curr = heights[i] + n - i - 1
    ans = min(ans, curr)
print(ans)


