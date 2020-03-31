#include<bits/stdc++.h>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n, k;
	vector<int> a(100005), dp(100005, 1e9);
	cin >> n >> k;
	for (int i = 1; i <= n; i++) {
		cin >> a[i];
	}
	dp[1] = 0;
	for (int i = 2; i <= n; i++) {
		for (int j = 1; j <= min(k, i); j++) {
			dp[i] = min(dp[i], dp[i-j] + abs(a[i] - a[i-j]));
		}
	}
	cout << dp[n];
}
