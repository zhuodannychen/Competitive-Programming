for tc in range(int(input())):
    n, k = map(int, input().split())
    c = (1 << n) - 1
    ans = "ON" if (k & c == c) else "OFF"
    print(f'Case #{tc+1}: {ans}')

