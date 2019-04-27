for i in range(int(input())):
    x=input().replace(" ", "").replace("and", "").replace(",","")
    x=list(x)
    sec=0
    min=0
    hour=0
    for j in range(len(x)):
        try:
            int(x[j])
            if(x[j+1]=="s"):

                sec=int(x[j])

            elif(x[j+1]=="m"):
                min=int(x[j])
            elif(x[j+1]=="h"):
                hour=int(x[j])
            else:

                if (x[j + 2] == "s"):
                    sec = int(x[j]+x[j+1])
                    del x[j+1]
                elif (x[j + 2] == "m"):
                    min = int(x[j]+x[j+1])
                    del x[j + 1]
                elif (x[j + 2] == "h"):
                    hour = int(x[j]+x[j+1])
                    del x[j + 1]

        except:
            pass
    print("{:02}:{:02}:{:02}".format(hour, min, sec))
