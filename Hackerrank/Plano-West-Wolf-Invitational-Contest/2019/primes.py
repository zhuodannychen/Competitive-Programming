import re

primes = []
boo = [True] * (int(1e6) + 1)
boo[0] = False; boo[1] = False
for i in range(2, len(boo)):
    if boo[i]:
        for j in range(i*i, len(boo), i):
            boo[j] = False
        primes.append(i)
def findPF(num):
    ans = []
    PF_idx = 0
    PF = primes[PF_idx]
    while PF * PF <= num:
        while num % PF == 0:
            num //= PF
            ans.append(PF)
        PF_idx += 1
        PF = primes[PF_idx]
    if num != 1:
        ans.append(num)
    return ans

cases = int(input())
for i in range(cases):
    ns = input()
    ls = re.split('[=x]', ns)
    for j in range(len(ls)):
        ls[j] = int(ls[j].strip())
    flag = False
    once = False
    sss = []
    for j in range(1, len(ls)):
        if not boo[ls[j]]:
            sss.append(ls[j])
            flag = True
    if flag:
        print('WRONG!')
        sss = sorted(set(sss))
        for e in sss:
            print(str(e) + ' is not a prime number.')
        lss = map(str, findPF(ls[0]))
        print(ls[0], end=' = ')
        s = ' x '.join(lss)
        print(s)
    if not flag:
        print('correct!')
        print(ns)
