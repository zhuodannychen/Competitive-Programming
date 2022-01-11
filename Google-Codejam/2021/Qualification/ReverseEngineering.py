for t in range(int(input())):
    n, c = map(int, input().split())
    if c < n-1 or c >= n*(n+1)//2:
        print(f'Case #{t+1}: IMPOSSIBLE')
    else:
        ans = [x for x in range(1, n+1)]
        left = 0
        right = n
        tog = False
        c -= n-1
        
        while c - (right-left-1) > 0:
            c -= right - left-1
            ans[left:right] = ans[left:right][::-1]
            if not tog:
                right -= 1
            else:
                left += 1
            tog = not tog

        if not tog:
            ans[left:left+c+1] = ans[left:left+c+1][::-1]
        if tog:
            ans[right-c-1:right] = ans[right-c-1:right][::-1]
        print(f'Case #{t+1}: {" ".join(map(str, ans))}')
        

