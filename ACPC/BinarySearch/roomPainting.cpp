#include<bits/stdc++.h>
using namespace std;


int main() {
    int n, m;
    cin >> n >> m;
    vector<int> canSize(n);
    vector<int> joeNeeds(m);

    for (int i = 0; i < n; i++)
        cin >> canSize[i];
    for (int i = 0; i < m; i++)
        cin >> joeNeeds[i];

    // need long long because each canSize can go up to 10^9. If you sum over
    // multiple 10^9, that will exceed range of int.
    long long totalWasted = 0;
    sort(canSize.begin(), canSize.end());

    for (int need : joeNeeds) {
        int low = 0;
        int high = n-1;
        while (low < high) {
            // using this calculation rather than (low + high) / 2 to prevent overflow
            int mid = low + (high - low) / 2;
            if (need > canSize[mid])
                low = mid + 1;
            else
                high = mid;
        }         
        totalWasted += canSize[low] - need;
    }
    cout << totalWasted << endl;
}
