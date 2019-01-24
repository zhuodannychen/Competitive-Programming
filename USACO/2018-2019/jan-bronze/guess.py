with open('guess.in') as f:
    animals = int(f.readline())
    arr = list(f.read().split('\n'))
    max1 = 0
    c = 1
    for i in range(animals):
        arr_compared = list(arr[i].split())
        # print(arr_compared)
        for j in range(c, animals):
            arr_current = (arr[j].split())
            del arr_current[1]
            # print(arr_current)
            arr_current = set(arr_current)
            set1 = set(arr_compared).intersection(arr_current)
            # print(set1)
            max1 = max(max1, len(set1))
        c += 1
    print(max1+1)
    pw = open("guess.out", "w")
    pw.write(str(max1+1))
    pw.close()
