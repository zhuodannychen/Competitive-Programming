while True:
    n = int(input())
    if n == 0:
        break
    names = []
    for i in range(n):
        names.append(input())
    names.sort(key=lambda x: (x[0], x[1]))
    for name in names:
        print(name)
    print()

