p = list(map(int, input().split()))
h_cuts = [0]
v_cuts = [0]
for i in range(p[2]):
    h_cuts.append(int(input()))
for i in range(p[3]):
    v_cuts.append(int(input()))
h_cuts.append(p[0])
v_cuts.append(p[1])
h_cuts.sort()
v_cuts.sort()
area = 0

for i, j in enumerate(h_cuts):
    for k, l in enumerate(v_cuts):
        if i % 2 == 1:
            if k % 2 == 1:
                # print((h_cuts[i] - h_cuts[i-1]) * (v_cuts[k] - v_cuts[k-1]))
                area += (h_cuts[i] - h_cuts[i-1]) * (v_cuts[k] - v_cuts[k-1])
        elif i != 0:
            if k % 2 == 0 and k != 0:
                # print((h_cuts[i] - h_cuts[i-1]) * (v_cuts[k] - v_cuts[k-1]))
                area += (h_cuts[i] - h_cuts[i-1]) * (v_cuts[k] - v_cuts[k-1])
print(area)
