#include<bits/stdc++.h>
using namespace std;

#define INF 1000000010
vector<pair<int, int>> adj[10005];
int dist[10005];

void dijkstra(int start) {
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push({start, 0});
    dist[start] = 0;
    while (!pq.empty()) {
        int node = pq.top().first;
        pq.pop();
        for (auto e : adj[node]) {
            int v = e.first;
            int w = e.second;
            if (dist[node] + w < dist[v]) {
                dist[v] = dist[node] + w;
                pq.push({v, dist[v]});
            }
        }
    }
}

int main() {
    int t; cin >> t;
    while(t--) {
        map<string, int> mp;
        int n, m, city_num = 0;
        cin >> n;
        for (int i = 0; i < n; i++) {
            string city; cin >> city;
            cin >> m;
            mp[city] = city_num;
            for (int i = 0; i < m; i++) {
                int u, w; cin >> u >> w;
                --u;
                adj[city_num].push_back({u, w});
            }
            city_num++;
        }
        
        int r; cin >> r;
        memset(dist, INF, sizeof(dist));
        while (r--) {
            string city1, city2; cin >> city1 >> city2;
            dijkstra(mp[city1]);
            cout << dist[mp[city2]] << "\n";
            memset(dist, INF, sizeof(dist));
        }
        for (int i = 0; i < n; i++) {
            adj[i].clear();
        }
    }
}
