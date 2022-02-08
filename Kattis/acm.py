from collections import defaultdict

que = defaultdict(int)
cnt = 0
totalTime = 0
while True:
    try:
        time, prob, status = input().split()
        if status == "right":
            totalTime += int(time) + que[prob]*20
            cnt += 1
        else:
            que[prob] += 1
    except:
        break
print(cnt, totalTime)
