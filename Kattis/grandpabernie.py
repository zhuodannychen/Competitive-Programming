# import sys
# LINES = sys.stdin.read().splitlines()[::-1]
# def input(): return LINES.pop()

n = int(input())
trips = {}
for i in range(n):
    loc, time = input().split()
    time = int(time)
    if loc in trips:
        trips[loc].append(time)
    else:
        trips[loc] = [time]
for k, v in trips.items():
    v.sort()
q = int(input())
for i in range(q):
    loc, op = input().split()
    op = int(op)
    print(trips[loc][op-1])
# print(trips)