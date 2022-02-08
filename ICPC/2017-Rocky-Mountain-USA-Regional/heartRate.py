for _ in range(int(input())):
    b, p = map(float, input().split())
    bpm = 60 * b / p
    low = p / (b-1)
    high = p / (b+1)
    print(f'{(60 / low) :.4f} {bpm:.4f} {60 / high : .4f}')

