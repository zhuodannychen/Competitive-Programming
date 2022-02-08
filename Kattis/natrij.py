from datetime import datetime

t1 = list(map(int, input().split(':')))
t2 = list(map(int, input().split(':')))
if t1 == t2:
    print('24:00:00')
    exit()
total1 = 3600*t1[0] + 60*t1[1] + t1[2]
total2 = 3600*t2[0] + 60*t2[1] + t2[2]
totalSec = 0
if total2 - total1 >= 0:
    totalSec = total2 - total1
else:
    totalSec = 24*3600 - total1 + total2

hours = totalSec // 3600
totalSec %= 3600
mins = totalSec // 60
totalSec %= 60
print(f'{hours:02d}:{mins:02d}:{totalSec:02d}')
