s = input()
ans = 0
seg = []
for i in range(len(s)):
    if s[i].isupper():
        seg.append([])
        seg[-1].append(s[i])
    else:
        seg[-1].append(s[i])
for i in range(len(seg)):
    if i != len(seg)-1:
        if len(seg[i]) % 4 > 0:
            ans += 4 - len(seg[i]) % 4
print(ans)
