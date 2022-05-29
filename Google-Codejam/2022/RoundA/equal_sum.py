t = int(input())

for tc in range(t):
    n = int(input())
    total = 0
    powers = []
    for i in range(30):
        powers.append(1 << i)
        total += (1 << i)

    vals = []
    for i in range(70):
        vals.append((1 << 29) + i + 1)
        total += (1 << 29) + i + 1
    # numbers we select
    print(*powers, *vals)

    judge = list(map(int, input().split()))
    total += sum(judge)
    vals += judge
    vals.sort(key=lambda x: -x)
    total //= 2

    setA = []
    setB = []
    for x in vals:
        if total > x:
            total -= x
            setA.append(x)
        else:
            setB.append(x)
    for i in range(30):
        if total & (1 << i):
            setA.append(1 << i)
        else:
            setB.append(1 << i)
    # we don't actually need setB
    print(*setA)

