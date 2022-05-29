from bisect import bisect_left

n = int(input())
nums = []
for _ in range(n):
    nums.append(int(input()))

ans = 0
for i in range(n):
    lis = [nums[i]]    
    for j in range(i+1, n):
        idx = bisect_left(lis, nums[j])
        if idx == len(lis):
            lis.append(nums[j])
        if idx == 0:
            continue
        else:
            lis[idx] = nums[j]

    lds = [nums[-1]]
    for j in range(n-1, i-1, -1):
        if nums[j] > nums[i]:
            continue
        idx = bisect_left(lds, nums[j])
        if idx == len(lds):
            lds.append(nums[j])
        else:
            lds[idx] = nums[j]
    # print('lis', len(lis), lis)
    # print('lds', len(lds), lds)
    ans = max(ans, len(lis) + len(lds) - 1)
print(ans)

