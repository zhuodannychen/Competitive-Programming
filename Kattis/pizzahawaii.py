for _ in range(int(input())):
    n = int(input())
    nativeIng = []
    foreignIng = []
    nativeMatch = {}
    foreignMatch = {}
    for i in range(n):
        pizza = input()
        foreign = list(input().split())
        native = list(input().split())
        for j in range(1, len(foreign)):
            if foreign[j] not in foreignIng:
                foreignIng.append(foreign[j])
            if foreign[j] not in foreignMatch:
                foreignMatch[foreign[j]] = [pizza]
            else:
                foreignMatch[foreign[j]].append(pizza)
        for j in range(1, len(native)):
            if native[j] not in nativeIng:
                nativeIng.append(native[j])
            if native[j] not in nativeMatch:
                nativeMatch[native[j]] = [pizza]
            else:
                nativeMatch[native[j]].append(pizza)
    nativeIng.sort()
    foreignIng.sort()
    for ingA in foreignIng:
        for ingB in nativeIng:
            if nativeMatch[ingB] == foreignMatch[ingA]:
                print('(' + ingA + ', ' + ingB + ')')
    print()


