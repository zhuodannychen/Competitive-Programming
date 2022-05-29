for _ in range(int(input())):
    n = int(input())
    nums = []
    for i in range(n):
        nums.append(input())
    nums.sort()
    bad = False
    for i in range(1, n):
        if nums[i-1] == nums[i][:len(nums[i-1])]:
            bad = True
            break
    print("NO" if bad else "YES")

