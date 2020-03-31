#include<bits/stdc++.h>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n, a[100005], dp[100005];
	cin >> n;
	memset(a, 0, sizeof(a));
	memset(dp, 0, sizeof(dp));
	for (int i = 1; i <= n; i++) {
		cin >> a[i];
	}
	dp[2] = abs(a[2] - a[1]);
	for (int i = 3; i <= n; i++) {
		dp[i] = min(dp[i-1] + abs(a[i] - a[i-1]), dp[i-2] + abs(a[i] - a[i-2]));
	}
	cout << dp[n];
}
