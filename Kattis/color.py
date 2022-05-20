s, c, k = map(int, input().split())
thing = sorted(list(map(int, input().split())))
start = thing[0]
count = 1
machine_count = 0
for i in thing:
    if i > start + k or machine_count == c:
        machine_count = 1
        count += 1
        start = i
    else:
        machine_count += 1
print(count)

