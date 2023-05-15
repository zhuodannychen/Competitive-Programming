s = input()
p1 = 0
p2 = 0
p3 = 0

prev = s[0]
for ch in s[1:]:
    if prev == 'U':
        if ch == 'D':
            p1 += 2
    else:
        p1 += 1
    prev = 'U'
print(p1)

prev = s[0]
for ch in s[1:]:
    if prev == 'D':
        if ch == 'U':
            p2 += 2
    else:
        p2 += 1
    prev = 'D'
print(p2)

for i in range(1, len(s)):
    if s[i] != s[i-1]:
        p3 += 1
print(p3)
