n = int(input())
for t in range(n):
    input()
    segs = list(input().split())
    blue = []
    red = []
    for seg in segs:
        if seg[-1] == 'R':
            red.append(int(seg[:-1]))
        else:
            blue.append(int(seg[:-1]))

    red.sort(reverse=True)
    blue.sort(reverse=True)

    ans = 0
    for i in range(min(len(red), len(blue))):
        ans += red[i]-1 + blue[i]-1
    print(f'Case #{t+1}: {ans}')
        

