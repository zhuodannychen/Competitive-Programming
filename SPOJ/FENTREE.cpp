#include <bits/stdc++.h>
using namespace std;

class FenwickTree{
private:
    int n;
    vector<long long> ft;
public:
    FenwickTree(int n) {
        this->n = n;
        ft.assign(n, 0);
    }
    FenwickTree(vector<long long> a) : FenwickTree(a.size()) {
        for (size_t i = 0; i < a.size(); i++)
            update(i, a[i]);
    }

    long long rsq(int r) {
        long long sum = 0;
        for (; r >= 0; r = (r&(r+1)) - 1)
            sum += ft[r];
        return sum;
    }

    long long rsq(int l, int r) {
        return rsq(r) - rsq(l-1);
    }

    void update(int idx, int val) {
        for (; idx < n; idx = idx | (idx + 1))
            ft[idx] += val;
    }
};

int main() {
    // assuming n is at least 4
    int n; cin >> n;
    FenwickTree ft(n);

    for (int i = 0; i < n; i++) {
        int x; cin >> x;
        ft.update(i, x);
    } 

    int q; cin >> q;
    while (q--) {
        string s; cin >> s;
        int u, v; cin >> u >> v;
        if (s == "q") {
            --u; --v;
            cout << ft.rsq(u, v) << "\n";
        } else {
            --u;
            ft.update(u, v);
        }
    }
}

// 1000000000
