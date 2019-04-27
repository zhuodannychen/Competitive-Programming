for i in range(int(input())):
    x=int(input())
    n=2**x
    for j in range(n):
        f=bin(j)[2:]
        hold="0"*(x-len(f))
        hold+=f
        print(hold)