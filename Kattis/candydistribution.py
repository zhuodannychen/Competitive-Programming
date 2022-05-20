# Extended Euclidean Algorithm

def egcd(a, b):
    if a == 0:
        return b, 0, 1
    gcd, x1, y1 = egcd(b%a, a)
    x = y1 - (b//a) * x1
    y = x1
    return gcd, x, y

def modinv(a, m):
    gcd, x, y = egcd(a, m)
    if gcd != 1:
        print('IMPOSSIBLE') # modular inverse does not exist
    else:
        print(x % m)


for _ in range(int(input())):
    k, c = map(int, input().split())
    # cx = 1 mod k
    if c == 1:
        print(k+1)
    elif k == 1 and c > 1:
        print(1)
    else:
        modinv(c, k)
