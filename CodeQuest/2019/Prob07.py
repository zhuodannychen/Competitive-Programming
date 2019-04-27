import math
for i in range(int(input())):
    x=[]
    for j in range(int(input())):
        x.append(float(input()))
    for k in x:
        print(int(round((k-min(x))/(max(x)-min(x))*255)))