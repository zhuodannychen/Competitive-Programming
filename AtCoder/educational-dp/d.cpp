#include<bits/stdc++.h>
using namespace std;

int main() {
	int n, w, items[105], weights[105];
	cin >> n >> w;
	vector<vector<long long>> dp (n+1, vector<long long> (w+1));
	for (int i = 1; i <= n; i++)
		cin >> weights[i] >> items[i];

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= w; j++) {
			dp[i][j] = dp[i-1][j];
			if (weights[i] <= j)
				dp[i][j] = max(dp[i][j], dp[i-1][j-weights[i]] + items[i]);
		}
	}
	cout << dp[n][w];
}
