/*
    dp[L][L] = 0 since there is no cost to combine a single item
    let dp[i][j] represent the min cost to combine an interval [i, j]
    then we just iterate through and keep the cost.
*/

#include<bits/stdc++.h>
using namespace std;

typedef long long ll;
const ll INF = 1e18L;
ll s[405], dp[405][405];

int main() {
    int n;
    s[0] = 0;
    cin >> n;
    vector<int> a (n+1);
    for (int i = 0; i < n; i++) {
        cin >> a[i];
        if (i == 0)
            s[i] = a[i];
        else
            s[i] = s[i-1] + a[i];
    } 
    for (int i = n-1; i >= 0; i--) {
        for (int j = i; j < n; j++) {
            if (i == j) {
                dp[i][j] = 0;
            }
            else {
                dp[i][j] = INF;
                for (int k = i; k < j; k++) {
                    dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j] + s[j] - s[i-1]);
                }
            }
        }
    }
    printf("%lld\n", dp[0][n-1]);
}

