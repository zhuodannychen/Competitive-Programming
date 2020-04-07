/*
	Let dp[i][j][k] represent the expected number of steps when you have i plates of 1 piece of sushi in it,
	j plates with 2 pieces, and k plates with 3 pieces.
	Let probabilities of selecting some plates be:
	p1 = i / (i + j + k)
	p2 = j / (i + j + k)
	p3 = k / (i + j + k)
	p0 = n - (i + j + k) / (i + j + k)

	the general formula then can be:
	
	dp[i][j][k] = 1 + p0 * dp[i][j][k] + p1 * dp[i-1][j][k] + p2 * dp[i+1][j-1][k] + p3 * dp[i][j+1][k-1]

	Note: when you remove a sushi from a plate with 3 pieces of sushi, you lose a plate with 3 sushi, but you also gain
	a plate with 2 pieces of sushi. Ex: dp[i][j+1][k-1]

	In addition, you can move p0 * dp[i][j][k] to the left side, and simplifying,
	(1 - p0) * dp[i][j][k]

*/
#include<bits/stdc++.h>
using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	int n, inp, cnt1 = 0, cnt2 = 0, cnt3 = 0;
	// the problem with using array is that it uses too much memory on the stack, but it still works on atcoder.
	double dp[305][305][305];
	// vector<vector<vector<double>>> dp (305, vector<vector<double>> (305 , vector<double> (305)));
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> inp;
		if (inp == 1)
			cnt1++;
		else if (inp == 2)
			cnt2++;
		else
			cnt3++;
	}
	dp[0][0][0] = 0;
	for (int k = 0; k <= cnt3; k++) {
		for (int j = 0; j <= cnt2 + cnt3; j++) {
			for (int i = 0; i <= cnt1 + cnt2 + cnt3; i++) {
				if (i == 0 && j == 0 && k == 0)
					continue;
				int s = i + j + k;
				if (k)
					dp[i][j][k] += 1.0 * k / s * dp[i][j+1][k-1];
				if (j)
					dp[i][j][k] += 1.0 * j / s * dp[i+1][j-1][k];
				if (i)
					dp[i][j][k] += 1.0 * i / s * dp[i-1][j][k];
				dp[i][j][k] += 1.0 * n / s;
			}
		}
	}
	printf("%.9f", dp[cnt1][cnt2][cnt3]);
}
