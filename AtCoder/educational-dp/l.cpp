/*
Left dp[L][R] represent the max answer when considering the interval between L and R.
Basically, Taro tries to maximize X - Y while Jiro tries to maximize Y - X.

Observation #1, dp[L][L] = a[L] because there is only 1 element.
After that, as a player, we can either take the left item (a[L]), which means subtract dp[L+1][R],
since the players are playing against each other.
or take the right item (a[R]), and subtract dp[L][R-1]

dp[0][n-1] is answer since it considers the entire interval.
*/
#include<bits/stdc++.h>
using namespace std;

int main() {
    int a[3000], n;
    cin >> n;
    vector<vector<long>> dp (n+1, vector<long> (n+1));
    for (int i = 0; i < n; i++)
        cin >> a[i];
    for (int L = n-1; L >= 0; L--) {
        for (int R = L; R < n; R++) {
            dp[L][R] = max(a[L] - dp[L+1][R], a[R] - dp[L][R-1]);
        }
    }
    cout << dp[0][n-1];
}

