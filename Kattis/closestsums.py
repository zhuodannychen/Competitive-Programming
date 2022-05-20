tc = 1
while True:
    try:
        n = int(input())
    except:
        break
    vals = []
    for i in range(n):
        vals.append(int(input()))
    vals.sort()
    m = int(input())
    print(f'Case {tc}:')
    tc+=1
    for i in range(m):
        q = int(input())
        left = 0
        right = n-1
        ansa = 0
        ansb = n-1

        ans = 1000000000
        while left != right:
            sm = vals[left] + vals[right]
            if ans > abs(sm-q):
                ans = abs(sm-q)
                ansa = left
                ansb = right
                
            ans = min(ans, abs(sm-q))
            if sm < q:
                left+=1
            else:
                right-=1
        print(f'Closest sum to {q} is {vals[ansa] + vals[ansb]}.')


