MOD = 1000000007

n, t = map(int, input().split())
a, b, c, t0 = map(int, input().split())

freq = [0 for i in range(1000001)]
nums = []
seen = {}
cur = t0
steps = 0
while cur not in seen:
    seen[cur] = steps
    freq[cur] += 1
    nums.append(cur)
    cur = (a*cur + b) % c + 1
    steps += 1

cycleSz = steps - seen[cur]
numCycles = (n - seen[cur]) // cycleSz
rem = (n - seen[cur]) % cycleSz

# update freq
for i in range(seen[cur], len(nums)):
    freq[nums[i]] += numCycles-1
# update the remaining freq
for i in range(rem):
    freq[nums[i+seen[cur]]] += 1

# print(freq[:20])
solved = 0
pen = 0
time = 0

for i in range(1, len(freq)):
    if time + freq[i]*i <= t:
        solved += freq[i]
        pen += (time*freq[i] + freq[i] * (freq[i]+1) // 2 * i) % MOD
        time += freq[i]*i
    else:
        extra = (t - time) // i
        solved += extra
        pen += (time*extra + extra * (extra+1) // 2 * i) % MOD
        time += extra * i
        break
print(solved, pen % MOD)


