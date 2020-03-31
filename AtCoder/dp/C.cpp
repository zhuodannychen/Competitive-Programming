/*
j is activity on current day
k is activity on previous day
*/
#include<bits/stdc++.h>
using namespace std;
 
int main() {
	int n, a[100005], b[100005], c[100005];
	cin >> n;
	vector<vector<int>> dp (n+1, vector<int>(3, 0));
	for (int i = 0; i < n; i++)
		cin >> a[i] >> b[i] >> c[i];
	dp[0][0] = a[0];
	dp[0][1] = b[0];
	dp[0][2] = c[0];
	for (int i = 1; i < n; i++) {
		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 3; k++) {
				if (j == k)
					continue;
				if (j == 0)
					dp[i][j] = max(dp[i][j], dp[i-1][k] + a[i]);
				else if (j == 1)
					dp[i][j] = max(dp[i][j], dp[i-1][k] + b[i]);
				else
					dp[i][j] = max(dp[i][j], dp[i-1][k] + c[i]);
			}
		}
	}
	cout << max({dp[n-1][0], dp[n-1][1], dp[n-1][2]});
}
