pw = open('cowsignal.out', 'w')

with open('cowsignal.in') as f:
    m, n, k = map(int, f.readline().split())
    for i in range(m):
        l = list(f.readline())
        del l[n]
        line = ''
        for j in range(n):
            for j1 in range(k):
                line += l[j]
        # print(line)
        for j in range(k):
            print(line)
            pw.write(line + '\n')

pw.close()
