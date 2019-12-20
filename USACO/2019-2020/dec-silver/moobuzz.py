import time
start = time.time()
f = open('moobuzz.in', 'r')
n = int(f.readline())
d = {
	0 : 1,
	1 : 2,
	2 : 4,
	3 : 7,
	4 : 8,
	5 : 11,
	6 : 13,
	7 : 14,
}
remainder = (n-1) % 8
r = (n-1)//8 * 15
print(r + d[remainder])
end = time.time()
print(end - start)
o = open('moobuzz.out', 'w')
o.write(str(r + d[remainder]))
o.close()
