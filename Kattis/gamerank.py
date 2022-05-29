s = input()
n = len(s)
currWins = 0
currStars = 0
currRank = 25
stars = [0,5,5,5,5,5,5,5,5,5,5,4,4,4,4,4,3,3,3,3,3,2,2,2,2,2]

for i in range(n):
    if s[i] == 'W':
        currWins += 1
        currStars += 1
    if s[i] == 'L':
        if currRank <= 20:
            currStars -= 1
        currWins = 0



    if currWins == 3 and currRank >= 6:
        currWins = 2
        currStars += 1
    if currStars > stars[currRank]:
        currStars -= stars[currRank]
        currRank -= 1

    if currRank == 0:
        print("Legend")
        exit()

    if currStars < 0:
        if currRank < 20:
            currRank += 1
            currStars = stars[currRank]-1
        else:
            currStars = 0


print(currRank)

