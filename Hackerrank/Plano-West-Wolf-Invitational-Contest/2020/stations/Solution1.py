g = int(input())
danny_wins = 0
dimmy_wins = 0
for i in range(g):
    n, x = map(int, input().split())
    if x % 3 != 0:
        if n % 3 == 0:
            dimmy_wins += 1
        else:
            danny_wins += 1
    if x % 3 == 0:
        n %= (x + 1)
        if n % 3 == 0 and n != x:
            dimmy_wins += 1
        else:
            danny_wins += 1
print(f'{danny_wins}:{dimmy_wins}')
