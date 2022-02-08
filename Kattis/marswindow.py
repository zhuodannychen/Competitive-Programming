n = int(input())
good = []
mod = 4
i = 2018
while i < 10010:
    good.append(i)
    mod += 2
    i += 2
    if mod > 12:
        i += 1
        mod = 2
print('yes' if n in good else 'no')

