line = list(input())
pairs = []
stack = []

for i, ch in enumerate(line):
    if ch == '(':
        stack.append(i)
    elif ch == ')':
        idx = stack.pop()
        pairs.append([idx, i])
pairs.sort()
# print(pairs)

ans = []
for bit in range(1, 1 << len(pairs)):
    copy = list(line)
    for pos in range(len(pairs)):
        if bit & (1 << pos):
            copy[pairs[len(pairs)-1-pos][0]] = ''
            copy[pairs[len(pairs)-1-pos][1]] = ''
    ans.append(''.join(copy))
    # print(''.join(copy))
ans = sorted(list(set(ans)))
for x in ans:
    print(x)



