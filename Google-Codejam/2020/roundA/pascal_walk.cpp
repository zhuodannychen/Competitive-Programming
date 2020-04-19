#include<bits/stdc++.h>
using namespace std;

typedef long long ll;
const ll INF = 1e18L;
const int MOD = 1e9 + 7;

int main() {
    int t;
    cin >> t;
    for (int tc = 1; tc <= t; tc++) {
        cout << "Case #" << tc << ":\n";
        int n;
        cin >> n;
        if (n <= 30) {
            for (int i = 0; i < n; i++)
                cout << i+1 << " 1\n"; 
        } else {
            n -= 30;
            int extra = 0;
            bool leftside = true;
            for (int i = 0; i < 30; i++) {
                if (leftside) {
                    cout << i+1 << " 1\n";
                    if (n & (1 << i)) {
                        for (int j = 1; j < i+1; j++) {
                            cout << i+1 << " " << j+1 << "\n";
                        }
                        extra++;
                        leftside = !leftside;
                    }
                } else {
                    cout << i+1 << " " << i+1 << "\n";
                    if (n & (1 << i)) {
                        for (int j = i-1; j >= 0; j--) {
                            cout << i+1 << " " << j+1 << "\n";
                        }
                        extra++;
                        leftside = !leftside;
                    }
                }
            }
            for (int i = 0; i < extra; i++) {
                if (leftside)
                    cout << i+31 << " 1\n";
                else
                    cout << i+31 << " " << i+31 << "\n";
            }
        }
    }
}

