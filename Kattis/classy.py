from functools import cmp_to_key


def cusSort(a, b):
    # alphabet u, m, l
    for i in range(min(len(a[2]), len(b[2]))):
        if a[2][i] < b[2][i]:
            return 1
        elif a[2][i] > b[2][i]:
            return -1
    return 1 if a[1] > b[1] else -1


t = int(input())
for tc in range(t):
    n = int(input())
    data = []

    for nn in range(n):
        inp = list(input().split())
        data.append([nn, inp[0][:-1], inp[1].split('-')[::-1]])
        while len(data[-1][2]) < 12:
            data[-1][2].append('middle')

    letter_cmp_key = cmp_to_key(cusSort)
    data.sort(key=letter_cmp_key)

    for name in data:
        print(name[1])
    # print(data)
    print('='*30)

