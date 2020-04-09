/*
Let dp[i] = True if Taro wins else Jiro, and i will be how many stones
are left in the pile.
0 stones will always be a loss for Taro since he goes first.
Then, the other positions will be determined by the values inside the set A.
*/
#include<bits/stdc++.h>
using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	int n, k;
	cin >> n >> k;
	vector<bool> dp (k+1);
	vector<int> a (n);
	for (int i = 0; i < n; i++)
		cin >> a[i];
	for (int i = 0; i <= k; i++) {
		for (int e : a) {
			if (e <= i && !dp[i-e])
				dp[i] = true;
		}
	}
	cout << (dp[k] ? "First" : "Second");
}

