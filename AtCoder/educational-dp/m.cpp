#include<bits/stdc++.h>
using namespace std;

#define MOD 1000000007;

long long dp[105][100005];
long long a[105], s[100005];

int main() {
    int n, k;
    cin >> n >> k;
	for (int i = 0; i < n; i++) 
        cin >> a[i];
    for (int i = 0; i <= n; i++)
        dp[i][0] = 1;
    for (int i = 0; i <= k; i++)
        dp[0][i] = 0;
	dp[0][0] = 1;
	for (int i = 1; i <= n; i++) {
        s[0] = 0;
		for (int j = 1; j <= k + 1; j++)
            s[j] = s[j - 1] + dp[i - 1][j - 1];
		for (int j = 1; j <= k; j++) {
			dp[i][j] = (s[j+1] - s[max(0ll, j-a[i-1])]) % MOD;
		}
	}
    cout << dp[n][k];
}


