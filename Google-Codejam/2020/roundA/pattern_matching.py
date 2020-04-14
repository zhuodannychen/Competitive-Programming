for tc in range(1, int(input()) + 1):
	n = int(input())
	a = ['' for x in range(n)]
	prefix = ['' for x in range(n)]
	suffix = ['' for x in range(n)]
	lp = 0
	ls = 0
	flag = False
	for i in range(n):
		a[i] = input()
		for j in range(len(a[i])):
			if a[i][j] != '*':
				prefix[i] += a[i][j]
			else:
				break
		if len(prefix[i]) > len(prefix[lp]):
			lp = i
		for j in range(len(a[i])-1, -1, -1):
			if a[i][j] != '*':
				suffix[i] += a[i][j]
			else:
				suffix[i] = suffix[i][::-1]
				break
		if len(suffix[i]) > len(suffix[ls]):
			ls = i
		
	for i in range(n):
		if prefix[lp][:len(prefix[i])] != prefix[i]:
			print('Case #' + str(tc) + ': *')
			flag = True
			break
		if suffix[ls][len(suffix[ls]) - len(suffix[i]):] != suffix[i]:
			print('Case #' + str(tc) + ': *')
			flag = True 
			break
	if not flag:
		ans = prefix[lp]
		for i in range(n):
			for ch in a[i]:
				if ch != '*':
					ans += ch
		ans += suffix[ls]
		print('Case #' + str(tc) + ': ' + ans)

