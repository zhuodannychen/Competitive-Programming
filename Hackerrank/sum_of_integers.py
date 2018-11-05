#https://www.hackerrank.com/contests/utd-hs-fall-18m/challenges

def sum1(n):
    for i in range(n):
        return int(n*(n+1)/2)
def odd(n):
    return n*n
def even(n):
    return n*(n+1)

MAX = 1000000

prime = [True for i in range(MAX + 1)] 

def SieveOfEratosthenes(): 
    prime[1] = False
    for p in range(2, MAX + 1): 
        if (prime[p] == True): 
            i = p * 2
            while(i <= MAX): 
                prime[i] = False
                i = i + p 

def solve(n): 
    # count of primes 
    count = 0
    num = 1
    # sum
    total = 0
    while (count < n): 
        if (prime[num]): 
            total += num 
            count += 1
        num += 1
    return total 

# create the sieve 
SieveOfEratosthenes() 
cases = int(input())
values = [cases*2]

# Reads two numbers from input and typecasts them to int using 
# list comprehension 
#flats list
array = [item for sublist in [list(map(int, input().split())) for i in range(cases)] for item in sublist]
#print(array)
idl = 1;
for i in range(1, cases*2):
    if(i % 2 !=0):
        sum2 = sum1(array[i])
        odd2 = odd(array[i])
        even2 = even(array[i])
        prime2 = solve(array[i])
        print(idl,sum2,odd2,even2,prime2)
        idl += 1
