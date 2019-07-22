t = int(input())
for i in range(t):
	n, k = map(int, input().split())
	if k % 3 != 0:
		if n % 3 == 0:
			print("Bob")
		else:
			print("Alice")
	if k % 3 == 0:
		n = n % (k + 1)
		if n % 3 == 0 and n != k:
			print("Bob")
		else:
			print("Alice")
