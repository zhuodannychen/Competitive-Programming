#include<bits/stdc++.h>
using namespace std;


int main() {
    int n, t;
    cin >> n >> t;

    vector<int> ks(n);
    for (int i = 0; i < n; i++)
        cin >> ks[i];

    long long low = 0;
    long long high = 1e18;

    while (low < high) {
        long long mid = low + (high - low) / 2;
        long long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += mid / ks[i];
            if (sum >= t) // needed to prevent overflow
                break;
        }

        if (sum >= t)
            high = mid;
        else
            low = mid + 1;
    }
    cout << low << endl;
}

