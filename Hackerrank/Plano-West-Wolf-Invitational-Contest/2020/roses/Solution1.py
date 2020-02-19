n = int(input())
max = list(map(int, input()))
kevin = list(map(int, input()))
days = 0
for i in range(n):
    if max[i] == kevin[i]:
        continue
    elif max[i] == 0 and kevin[i] == 1:
        max[i] = 1
        days+=1
    elif max[i] == 1 and kevin[i] == 0:
        count = i
        while count < n-1 and max[count+1] == 1:
            max[count] = 0
            count+=1
        max[count] = 0
        count += 1
        if count < n:
            max[count] = 1
        days+=1
print(days)
