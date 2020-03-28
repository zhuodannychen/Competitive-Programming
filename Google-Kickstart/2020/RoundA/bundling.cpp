#include <bits/stdc++.h>
using namespace std;

const int MaxNodes = 2000005;
const int alphabet = 26;
int sz, trie[MaxNodes][alphabet], cnt[MaxNodes], k;

long long ans;

void dfs(int u=0, int d=0) {
    for (int i = 0; i < 26; i++) {
        if (trie[u][i]) {
            dfs(trie[u][i], d+1);
            cnt[u] += cnt[trie[u][i]];
        }
    }
    while (cnt[u] >= k) {
        cnt[u] -= k;
        ans += d;
    }
}

void insert(string str) {
    int u = 0;
    for (char c : str) {
        if (!trie[u][c-'A'])
            trie[u][c-'A'] = sz++;
        u = trie[u][c-'A'];
    }
    ++cnt[u];
}

bool search (string str) {
    int u = 0;
    for (char c : str) {
        if (!trie[u][c-'A'])
            return false;
        u = trie[u][c-'A'];
    }
    return cnt[u] > 0;
}

int main() {
    // freopen("input.txt", "r", stdin);
    ios::sync_with_stdio(0);
    cin.tie(0);

    int cases, words;
    cin >> cases;
    for (int i = 1; i <= cases; i++) {
        cout << "Case #" << i << ": ";
        cin >> words >> k;
        sz = 1;
        ans = 0;
        for (int j = 0; j < words; j++) {
            string inp;
            cin >> inp;
            insert(inp);
        }
        dfs();
        cout << ans << "\n";
        memset(trie, 0, sizeof(trie[0])*sz);
        memset(cnt, 0, 4*sz);
    }
}
