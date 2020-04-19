/*
    Looking at the constraints, it has to be a bitmask dp.
    Assume i is mask from 1 to (1 << n), also 2^n
    Let c be number of 'on' bits in the mask.
    Let dp[i] = the # of ways the first c men can pair with any c women.
    We then can just sum dp[i]/
*/
#include<bits/stdc++.h>
using namespace std;

typedef long long ll;
const ll INF = 1e18L;
const int MOD = 1e9 + 7;
int a[21][21];

int main() {
    int n;
    cin >> n;
    vector<int> dp (1 << n);
    for (int i = 0; i < n; i++) 
        for (int j = 0; j < n; j++) 
            cin >> a[i][j];

    dp[0] = 1;
    for (int i = 1; i < (1 << n); i++) {
        int c = __builtin_popcount(i) - 1; // count the number of 1's in mask i.
        for (int j = 0; j < n; j++) {
            if (a[c][j] && (i & (1 << j)))
                dp[i] = (dp[i] + dp[i ^ (1 << j)]) % MOD; // i ^ (1 << j) flips the bit at j.
        }
    }
    cout << dp[(1 << n) - 1];
}

