def mergesort(arr):
    inversions = 0
    if len(arr) > 1:
        mid = len(arr) // 2
        left = arr[:mid]
        right = arr[mid:]
        inversions += mergesort(left);
        inversions += mergesort(right);

        i = j = k = 0
        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                arr[k] = left[i]
                i += 1
            else:
                arr[k] = right[j]
                j += 1
                inversions += len(left) - i
            k += 1
        while i < len(left):
            arr[k] = left[i]
            i += 1
            k += 1
        while j < len(right):
            arr[k] = right[j]
            j += 1
            k += 1

    return inversions

n = int(input())
nums = []
for i in range(n):
    nums.append(int(input()))
print(mergesort(nums))

