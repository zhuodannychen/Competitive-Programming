m = 998244353
 
 
def bin_exp(a, b):
    res = 1
    while b > 0:
        if b & 1:
            res = res * a % m
        a *= a % m
        b >>= 1
    return res
 
 
def comb(a, b):
    return fac[a] // (fac[b] * fac[a - b])
 
 
n, k = map(int, input().split())
# precomputed factorial
fac = [1]
for i in range(1, k+1):
    fac.append(fac[i-1] * i % m)

# Using Fermat's Little Theorem, we can see that a^(p-1) triple-bar 1 mod(p)
# multiplying a^-1 by both sides, it becomes a^p-2 triple-bar a^-1 mod(p)
# a^-1 == inverse, which is why we raise to power of m-2.
print(fac[k] * bin_exp(fac[n - 1] * fac[k - n + 1], m - 2) * (n - 2) * bin_exp(2, n - 3) % m)
