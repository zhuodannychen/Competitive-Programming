def winner(a, b, one, two):
    if a == b:
        return 0
    if a == "rock":
        if b == "paper":
            return two
        else:
            return one
    if a == "paper":
        if b == "scissors":
            return two
        else:
            return one
    if a == "scissors":
        if b == "paper":
            return one
        else:
            return two


while True:
    try:
        n, k = map(int, input().split())
        stats = [[0,0] for x in range(n+1)]
        
        for i in range(k*n*(n-1)//2):
            inp = list(input().split())
            inp[0] = int(inp[0])
            inp[2] = int(inp[2])
            if winner(inp[1], inp[3], inp[0], inp[2]) == inp[0]:
                stats[inp[0]][0] += 1
                stats[inp[2]][1] += 1
            elif winner(inp[1], inp[3], inp[0], inp[2]) == inp[2]:
                stats[inp[0]][1] += 1
                stats[inp[2]][0] += 1
        for i in range(1, n+1):
            if stats[i][0]+stats[i][1] == 0:
                print("-")
            else:
                print(f"{stats[i][0] / (stats[i][0]+stats[i][1]):.3f}")
        print()
    except:
        break
