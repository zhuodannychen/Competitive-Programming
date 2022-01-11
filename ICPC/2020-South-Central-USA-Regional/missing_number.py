n = int(input())
a = input()
idx = 0
for i in range(1, n+1):
    curr = str(i)
    if a[idx:idx+len(curr)] != curr:
        print(i)
        break
    idx += len(curr)

