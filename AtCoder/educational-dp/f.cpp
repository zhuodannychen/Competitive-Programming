#include<bits/stdc++.h>
using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	char s[3005], t[3005];
	cin >> s >> t;
	int n = strlen(s);
	int m = strlen(t);

	// creates the dp table of longest common length
	vector<vector<int>> dp (n+1, vector<int> (m+1, 0));
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (s[i-1] == t[j-1]) {
				dp[i][j] = dp[i-1][j-1] + 1;
			} else {
				dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
			}
		}
	}
	// now we just need to figure out the actual string
	int longest = dp[n][m];
	char ans[longest];
	int count = longest - 1;
	while (n > 0 && m > 0) {
		if (s[n-1] == t[m-1]) {
			ans[count] = s[n-1];
			n--; m--;
			count--;
		} else {
			if (dp[n][m-1] > dp[n-1][m])
				m--;
			else 
				n--;
		}
	}
	for (auto ch : ans)
		cout << ch;
}
