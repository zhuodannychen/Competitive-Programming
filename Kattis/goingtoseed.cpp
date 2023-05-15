#include<bits/stdc++.h>
using namespace std;


// In a range of length L, you can split the segment into 4 equal size pieces such that
// Applejack searches the 1st segment, Applejack and Applebloom searches 2nd, applebloom searches
// the 3rd segment, and no one searches the 4th segment. These correspond to 10, 11, 01, 00 based on the response.
// Thus, you can reduce the search space down by a factor of 4 every query

int main() {
    int n; cin >> n;
    int left = 1;
    int right = n;

    while (true) {
        int l1 = left;
        int r1 = left + (right-left+1)/2; // always round up to balance segment sizes. TC: 13
        int l2 = l1 + (r1-l1+1)/2;
        int r2 = r1 + (right-r1+1)/2;
        if (right - left <= 3) {
            l2 = l1+1;
            r1 = l2;
            r2 = min(n, r1+1);
        }

        cout << "Q " << l1 << " " << r1 << " " << l2 << " " << r2 << endl;
        cout.flush();
        int p1, p2; cin >> p1 >> p2;

        if (right - left <= 3) {
            if (p1 == 1 && p2 == 0)
                cout << "A " << l1 << endl;
            else if (p1 == 1 && p2 == 1)
                cout << "A " << r1 << endl;
            else if (p1 == 0 && p2 == 1)
                cout << "A " << r2 << endl;
            else
                cout << "A " << right << endl;
            break;
        }

        if (p1 == 1 && p2 == 1) {
            right = min(n, r1+1);
            left = max(1, l2-1);
        }
        else if (p1 == 0 && p2 == 0) {
            right = min(n, right+1);
            left = r2;
        } else if (p1 == 1 && p2 == 0) {
            right = l2;
            left = max(1, l1-1);
        } else {
            right = min(n, r2+1);
            left = r1;
        }
    }
}

