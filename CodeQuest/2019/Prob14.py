for i in range(int(input())):
    x=[]
    p=int(input())
    for j in range(p):
       x.append(tuple(input().split()))
    x=dict(x)
    list2=[]
    for cit1, cit2 in x.items():
        list2.append(cit1)
        list2.append(cit2)
    list1=[False]*len(list2)
    for r in range(len(list2)):
        for c in range(len(list2)):
            if list2[r]==list2[c] and r!=c:
                list1[r]=True
    start=""
    end=""
    if(list1.index(False)%2==1):
        end=list2[list1.index(False)]
        start=list2[list1.index(False, list1.index(False)+1, len(list2))]
    else:
        start = list2[list1.index(False)]
        end = list2[list1.index(False, list1.index(False)+1, len(list2))]
    path=[start]
    for o in range(p):
        if(start!=end):
            path.append(x[start])
            start=x[start]
    print("\n".join(path[::-1]))