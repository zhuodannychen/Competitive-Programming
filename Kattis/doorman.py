n =int(input())
m, w = 0,0
s = list(input())[::-1]
ans = 0
while len(s) > 1:
    if m < w:
        if s[-1] == 'M':
            s.pop()
            m += 1
        elif s[-2] == 'M':
            s.pop(-2)
            m += 1
        else:
            w += 1
            s.pop()
        ans += 1
    elif w < m:
        if s[-1] == 'W':
            s.pop()
            w += 1
        elif s[-2] == 'W':
            s.pop(-2)
            w += 1
        else:
            m += 1
            s.pop()
        ans += 1
    else:
        if s[-1] == 'W':
            w += 1
        else:
            m += 1
        s.pop()
        ans += 1

    if abs(m-w) > n:
        ans -= 1
        break
if abs(w-m) < n:
    ans += 1
print(ans)



    
    

