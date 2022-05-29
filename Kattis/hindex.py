n = int(input())
cits = []
for i in range(n):
    cits.append(int(input()))
# cits.sort()

left = 0
right = n
while left < right:
    mid = left + (right-left+1)//2
    num = 0
    for i in range(n):
        if cits[i] >= mid:
            num += 1
    if num >= mid:
        left = mid
    else:
        right = mid - 1
print(left)
