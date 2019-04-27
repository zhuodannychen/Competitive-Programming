def charing(str):
    if str!=" ":
        return ord(str)
    return " "
for i in range(int(input())):
    n=int(input())%26
    raw= list(input())
    new=[]
    for c in raw:
        new.append(charing(c))
    for a in range(len(new)):
        if new[a]!=" ":
            new[a]-=n
            if new[a]<97:
                new[a]+=26
    string=""
    for chrr in new:
        if chrr!=" ":
            string+=chr(chrr)
        else:
            string+=chrr
    print(string)

