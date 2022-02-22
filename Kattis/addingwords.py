words = {}
vals = {}
while True:
    try:
        line = list(input().split())
    except:
        break
    if line[0] == "def":
        if line[1] in words:
            del vals[words[line[1]]]
            words[line[1]] = int(line[2])
            vals[int(line[2])] = line[1] 
        else:
            words[line[1]] = int(line[2])
            vals[int(line[2])] = line[1] 
    elif line[0] == "clear":
        words.clear()
        vals.clear()
    else:
        bad = False
        if line[1] not in words:
            print(*line[1:], "unknown")
            bad = True
            continue

        ans = words[line[1]]
        for i in range(2, len(line)-1, 2):
            if line[i+1] not in words:
                bad = True
                print(*line[1:], "unknown")
                break
            if (line[i] == "-"):
                ans -= words[line[i+1]]
            else:
                ans += words[line[i+1]]
        if not bad:
            if ans in vals:
                print(*line[1:], vals[ans])
            else:
                print(*line[1:], "unknown")


