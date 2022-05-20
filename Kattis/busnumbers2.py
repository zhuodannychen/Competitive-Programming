n = int(input())
cnts = [0 for x in range(400005)]
cnt = 0
for i in range(1, 79):
    for j in range(i+1, 79):
        comp = i**3 + j**3
        if comp >= 400005:
            continue
        else:
            cnts[comp] += 1
idx = n
while idx >= 0:
    if cnts[idx] >= 2:
        print(idx)
        exit()
    idx -= 1
print("none")


        

