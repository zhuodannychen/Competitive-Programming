#include <bits/stdc++.h>
using namespace std;

const int MAXN = 100005;
#define all(v) v.begin(), v.end()

int n, arr[MAXN]; 
pair<int, int> arr2[MAXN];
vector<int> tree[4*MAXN];

void build(int node, int left, int right) {
    if (left == right) {
        tree[node].push_back(arr2[left].second);
        return;
    }
    int mid = (left + right) / 2;
    build(2*node, left, mid);
    build(2*node+1, mid+1, right);

    merge(all(tree[2*node]), all(tree[2*node+1]), back_inserter(tree[node]));
}

int query(int node, int left, int right, int ql, int qr, int val) {
    if (left == right) return tree[node].back();
    int x = upper_bound(all(tree[2*node]), qr) - lower_bound(all(tree[2*node]), ql);
    int mid = (left + right) / 2;
    if (x >= val) return query(2*node, left, mid, ql, qr, val);
    else return query(2*node+1, mid+1, right, ql, qr, val-x);
}


int main() {
    int n, m; cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        cin >> arr[i];
        arr2[i] = {arr[i], i};
    }
    sort(arr2+1, arr2+n+1);
    build(1, 1, n);
    while (m--) {
        int a, b, c; cin >> a >> b >> c;
        int idx = query(1, 1, n, a, b, c);
        cout << arr[idx] << "\n";
    }
}

