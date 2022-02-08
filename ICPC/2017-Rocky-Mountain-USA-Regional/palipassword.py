for _ in range(int(input())):
    n = int(input())
    ans = 0
    for i in range(1, 10):
        for j in range(10):
            for k in range(10):
                num = int(str(i) + str(j) + str(k) + str(k) + str(j) + str(i))
                if abs(num-n) < abs(ans-n):
                    ans = num
    print(ans)

