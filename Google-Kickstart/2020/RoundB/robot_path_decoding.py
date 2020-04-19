for tc in range(1, int(input()) + 1):
    l = list(input())
    mult = [1]
    times = 1
    x = 0
    y = 0
    for i in range(len(l)):
        if l[i].isdigit():
            times *= int(l[i]) % int(1e9)
            mult.append(times)
        elif l[i] == '(':
            continue
        elif l[i] == ')':
            mult.pop()
            times = mult[-1]
        else:
            if l[i] == 'S':
                y = (y + times) % int(1e9)
            elif l[i] == 'N':
                y = (y - times + int(1e9)) % int(1e9)
            elif l[i] == 'W':
                x = (x - times + int(1e9)) % int(1e9)
            else:
                x = (x + times) % int(1e9)
    print('Case #' + str(tc) + ': ' + str(x + 1) + ' ' + str(y + 1))

