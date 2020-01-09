# by running 2 dfs, you can get the longest path in a tree. First run a dfs from any node,
# and the resulting node will be one of the endpoints. Then run another dfs from that point.
# the length is the answer.
def dfs(v, path_len):
    global maxLe
    global last
    visited[v] = True
    if path_len > maxLe:
        last = v
        maxLe = path_len
    for i in range(len(adj[v])):
        if not visited[adj[v][i]]:
            dfs(adj[v][i], path_len+1)


n = int(input())
visited = [False] * n
maxLe = 0
last = 0
adj = {}
for i in range(n-1):
    u, v = map(int, input().split())
    u-=1; v-=1
    if u in adj:
        adj[u].append(v)
    else:
        adj[u] = [v]
    if v in adj:
        adj[v].append(u)
    else:
        adj[v] = [u]


dfs(0, 0)
# print(maxLe)
visited = [False] * n
dfs(last, 0)
print(maxLe)
