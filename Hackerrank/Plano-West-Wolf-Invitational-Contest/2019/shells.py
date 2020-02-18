n = int(input())
for i in range(n):
    a, b = map(int, input().split())
    if(a % 2 == 1 and b % 2 == 0 and a+b>=10):
        print("OPEN")
    else:
        print("CLOSED")
