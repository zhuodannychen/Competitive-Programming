for i in range(int(input())):
    x=list(map(int, input().split()))
    if(x[0]==x[1]):
        print(2*sum(x))
    else:
        print(sum(x))