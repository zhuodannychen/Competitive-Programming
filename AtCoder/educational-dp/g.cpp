#include<bits/stdc++.h>
using namespace std;

vector<int> adj[100005], dp(100005, -1);
int n, m, u, v, visited[100005];

void dfs(int node) {
	visited[node] = 1;
	for (int i = 0; i < adj[node].size(); i++) {
		if (!visited[adj[node][i]])
			dfs(adj[node][i]);
		dp[node] = max(dp[node], dp[adj[node][i]] + 1);
	}
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n >> m;
	
	for (int i = 0; i < m; i++) {
		cin >> u >> v;
		u--; v--;
		adj[u].push_back(v);
	}
	for (int i = 0; i < n; i++) {
		if (!visited[i])
			dfs(i);
	}
	int ans = 0;	
	for (int e : dp) {
		ans = max(ans, e);
	}
	cout << ans + 1;
}
