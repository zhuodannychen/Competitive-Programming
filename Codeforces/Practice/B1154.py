n = int(input())
s = sorted(list(set(list(map(int, input().split())))))
# print(s)
if len(s) > 3:
	print(-1)
elif len(s) == 3:
	if s[2] - s[1] == s[1] - s[0]:
		print(s[2] - s[1])
	else:
		print(-1)
elif len(s) == 2:
	if (s[1] - s[0]) % 2 == 0:
		print(int((s[1] - s[0]) / 2))
	else:
		print(s[1] - s[0])
else:
	print(0)
