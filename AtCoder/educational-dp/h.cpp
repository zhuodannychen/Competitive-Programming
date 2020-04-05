#include<bits/stdc++.h>
using namespace std;


int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	int n, m;
	char grid[1005][1005];
	string inp;
	cin >> n >> m;
	vector<vector<int>> dp (n+1, vector<int> (m+1));
	for (int i = 0; i < n; i++)
		cin >> grid[i];
	for (int i = 0; i < n; i++)
		if (grid[i][0] != '#')
			dp[i][0] = 1;
		else
			break;
		
	for (int i = 0; i < m; i++)
    	if (grid[0][i] != '#')
			dp[0][i] = 1;
		else
			break;

	for (int i = 1; i < n; i++) {
		for (int j = 1; j < m; j++) {
			if (grid[i][j] == '#') {
				dp[i][j] = 0;
			} else {
				dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
			}
		}
	}
	cout << dp[n-1][m-1] % 1000000007;
}
