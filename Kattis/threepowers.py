powers = []
num = 0
while num < 70:
    val = pow(3, num)
    powers.append(val)
    num += 1

while True:
    n = int(input())
    if n == 0:
        break
    binary = bin(n-1)[2::]
    binary = binary[::-1]
    ans = []
    # print(binary, len(binary))
    for i in range(len(binary)):
        if binary[i] == '1':
            ans.append(powers[i])
    print('{ ', end='')
    for i in range(len(ans)-1):
        print(ans[i], end=', ')
    if len(ans) > 0:
        print(ans[-1], end='')
    print(' }')

