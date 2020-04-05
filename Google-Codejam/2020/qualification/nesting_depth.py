for i in range(1, int(input()) + 1):
    s = list(map(int, input()))
    depth = 0
    print('Case #{}: '.format(i), end="")
    for j in range(s[0]):
        print("(", end="")
        depth+=1
    for j in range(1, len(s)):
        print(s[j - 1], end="")
        if s[j] > s[j-1]:
            for k in range(s[j] - s[j-1]):
                print("(", end="")
                depth+=1
        elif s[j] < s[j-1]:
            for k in range(s[j-1] - s[j]):
                print(")", end="")
                depth-=1
    print(s[-1], end="")
    for j in range(s[-1]):
        print(")", end="")
    print()

