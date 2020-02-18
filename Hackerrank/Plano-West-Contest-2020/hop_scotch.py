n, m = map(int, input().split())
l = []
visited = [False] * n
count = m-1
flag = False

for i in range(n):
    l.append(int(input()) % n)
while not visited[count]:
    visited[count] = True
    count = (count + l[count]) % n
    if count == m-1:
        print("YES")
        flag = True
        break
    
if not flag:
    print("NO")
