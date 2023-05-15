seen = set()
while True:
    try:
        sx = list(input().split())
        for s in sx:
            if s.lower() not in seen: 
                seen.add(s.lower())
                print(s, end=' ')
            else:
                print('.', end=' ')
        print()
    except:
        break
