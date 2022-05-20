import math

t = int(input())
for _ in range(t):
    n, e = map(int, input().split())
    carToInt = {}
    for i in range(n):
        cur = list(input().split())
        cur[1] = int(cur[1])
        cur[2] = int(cur[2])
        cur[3] = int(cur[3])
        carToInt[cur[0]] = cur[1:]

    events = []
    spies = {} # carType, cost, isConsistent
    for i in range(e):
        events.append(list(input().split()))
        events[i][0] = int(events[i][0])
        if events[i][1] not in spies:
            spies[events[i][1]] = ['', 0, 0];

    events.sort()
    for event in events:
        if spies[event[1]][2] == 1:
            continue
        if event[2] == 'p':
            if spies[event[1]][0] != '': # more than one car
                spies[event[1]][2] = 1
            else:
                spies[event[1]][0] = event[3]
                spies[event[1]][1] += carToInt[spies[event[1]][0]][1]
        elif event[2] == 'r':
            if spies[event[1]][0] == '': # no car
                spies[event[1]][2] = 1
            else:
                spies[event[1]][1] += carToInt[spies[event[1]][0]][2] * int(event[3])
                spies[event[1]][0] = ''
        else:
            if spies[event[1]][0] == '':
                spies[event[1]][2] = 1
            else:
                spies[event[1]][1] += math.ceil(carToInt[spies[event[1]][0]][0] * int(event[3]) / 100)
    ans = list(spies.items())
    ans.sort()
    for val in ans:
        if val[1][2] == 1 or val[1][0] != '':
            print(val[0] + " INCONSISTENT")
        else:
            print(val[0] + " " + str(val[1][1]))

                 

        

