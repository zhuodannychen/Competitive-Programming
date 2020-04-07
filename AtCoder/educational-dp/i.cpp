#include<bits/stdc++.h>
using namespace std;

#define MEM(a, b) memset(a, (b), sizeof(a))
#define FOR(i, ii, n) for (int i = ii; i < n; i++)
#define FRO(i, ii, n) for (int i = ii; i > n; i--)
#define MP make_pair
#define PB push_back
#define INF (int) 1e9
#define MOD 1000000007 // 998244353
#define PI 3.141592653589793238462643383279502884197169399375105820974945
typedef long long ll;
typedef vector<int> VI;
typedef vector<ll> VL;
typedef pair<int, int> PII;
typedef vector<string> VS;
typedef vector<VI> VII;

/* 
	State dp[i][j] means the probability when there are currently i heads and j tails
	We sum all the probabilities of when i + j == n, so starting with all n heads until
	the number of heads is less than tails.
*/

int main() {
	int n, inp;
	double prob[3005];
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n;
	vector<vector<double>> dp (n+1, vector<double> (n+1));
	for (int i = 0; i < n; i++)
		cin >> prob[i];
	dp[0][0] = 1;
	for (int i = 1; i <= n; i++) {
		for (int j = 0; j <= i; j++) {
			int heads = j, tails = i - j;
			if (heads)
				dp[heads][tails] += dp[heads-1][tails] * prob[i-1];
			if (tails)
				dp[heads][tails] += dp[heads][tails-1] * (1 - prob[i-1]);
		}
	}

	double ret = 0;
	int heads = n, tails = 0;
	while (heads > tails) {
		ret += dp[heads][tails];
		heads--; tails++;
	}

	printf("%.10f", ret);
}
