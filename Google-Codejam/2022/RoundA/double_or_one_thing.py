t = int(input())
for tc in range(t):
    # print tc
    ans = ''
    s = input()
    low = 1
    for i in range(1, len(s)):
        if s[i-1] < s[i]:
            ans += 2 * low * s[i-1]
            low = 1
        elif s[i-1] > s[i]:
            ans += low * s[i-1]
            low = 1
        else:
            low += 1
    ans += low * s[-1]
    print(f"Case #{tc+1}: {ans}")

