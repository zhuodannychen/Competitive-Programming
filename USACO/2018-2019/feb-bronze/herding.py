with open('herding.in') as f:
	a,b,c = map(int, f.readline().split())
	l = [a,b,c]
	l.sort()

	mi = l[0]
	ma = l[2]
	middle = l[1]
	minA = 0
	maxA = 0

	if ma - mi == 2 and middle + 1 == ma:
		minA = 0
	else:
		if ma - middle == 2 or middle - minA == 2:
			minA = 1
		else:
			minA = 2

	
	if ma - mi == 2 and middle + 1 == ma:
		maxA = 0
	else:
		maxA = max(ma - (middle+1), middle-1 - mi)

	print(minA)
	print(maxA)
	pw = open("herding.out", 'w')
	pw.write(str(minA) + '\n')
	pw.write(str(maxA))
	pw.close()
        
