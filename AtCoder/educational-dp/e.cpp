/*
Rather than representing dp[i][j] as the max value, we can represent
it as the min weight required to take a value of j given the first i items.
If we can't represent a value, it's set to inf.
*/
#include<bits/stdc++.h>
using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	int n, w, items[105], weights[105];
	int ans = 0;
	cin >> n >> w;
	int total_value = 0;
	for (int i = 1; i <= n; i++) {
		cin >> weights[i] >> items[i];
		total_value += items[i];
	}
	vector<vector<long long>> dp (n+1, vector<long long> (total_value+1));
	for (int i = 1; i <= total_value; i++)
		dp[0][i] = 1e18;
	dp[0][0] = 0;
	for (int i = 1; i <= n; i++) {
		for (int j = 0; j <= total_value; j++) {
			dp[i][j] = dp[i-1][j];
			if (items[i] <= j)
				dp[i][j] = min(dp[i][j], dp[i-1][j-items[i]] + weights[i]);
			if (dp[i][j] <= w)
				ans = max(ans, j);
		}
	}
	cout << ans;
}
