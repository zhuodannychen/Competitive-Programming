import math

def round(num):
    return math.floor(num + 0.5)

while True:
    x = int(input())
    if x == 0:
        break
    if x > 0:
        power = 31
        found = False
        while power >= 2:
            b = round(pow(x, 1/power))
            if pow(b, power) == x:
                print(power)
                found = True
                break
            power -= 1
        if not found:
            print(1)
    elif x < 0:
        power = 31
        found = False
        x = abs(x)
        while power >= 3:
            b = round(pow(x, 1/power))
            if pow(b, power) == x:
                print(power)
                found = True
                break
            power -= 2
        if not found:
            print(1)
        

    
            

