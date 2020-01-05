n = int(input())
key = list(input())
for i in range(n):
    arr = list(input())
    for ch in arr:
        if ch != ' ':
            print(chr(65 + key.index(ch)), end='')
        else:
            print(' ', end='')
    print()
