#include<bits/stdc++.h>
using namespace std;

#define MEM(a, b) memset(a, (b), sizeof(a))
#define f0r(i, n) for (int i = 0; i < n; i++)
#define rep(i, a, n) for (int i = a; i < n; i++)
#define mp make_pair
#define pb push_back
#define ff first
#define ss second
#define inf 1000005000
#define lnf 2000000000000500000ll
#define MOD 1000000007 // 998244353 1000000007
#define PI 4 * atan(1)
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
#define all(v) v.begin(), v.end()
#define rall(v) v.rbegin(), v.rend()
#define POPCOUNT __builtin_popcountll
#define RIGHTMOST __builtin_ctzll
#define LEFTMOST(x) (63-__builtin_clzll((x)))
typedef long long ll;
typedef vector<int> vi;
typedef vector<double> vd;
typedef vector<ll> vll;
typedef vector<string> vs;
typedef vector<vi> vii;
typedef pair<int, int> pii;

#define n_l '\n'
#define debug(...) cout << "[DBG]("<<__FUNCTION__<<":"<<__LINE__<<") " << "["<< #__VA_ARGS__ <<"]: "; cout << to_string(__VA_ARGS__) << endl
template <typename T, size_t N> int SIZE(const T (&t)[N]){ return N; } template<typename T> int SIZE(const T &t){ return t.size(); } string to_string(const string s, int x1=0, int x2=1e9){ return '"' + ((x1 < s.size()) ? s.substr(x1, x2-x1+1) : "") + '"'; } string to_string(const char* s) { return to_string((string) s); } string to_string(const bool b) { return (b ? "true" : "false"); } string to_string(const char c){ return string({c}); } template<size_t N> string to_string(const bitset<N> &b, int x1=0, int x2=1e9){ string t = ""; for(int __iii__ = min(x1,SIZE(b)),  __jjj__ = min(x2, SIZE(b)-1); __iii__ <= __jjj__; ++__iii__){ t += b[__iii__] + '0'; } return '"' + t + '"'; } template <typename A, typename... C> string to_string(const A (&v), int x1=0, int x2=1e9, C... coords); int l_v_l_v_l = 0, t_a_b_s = 0; template <typename A, typename B> string to_string(const pair<A, B> &p) { l_v_l_v_l++; string res = "(" + to_string(p.first) + ", " + to_string(p.second) + ")"; l_v_l_v_l--; return res; } template <typename A, typename... C> string to_string(const A (&v), int x1, int x2, C... coords) { int rnk = rank<A>::value; string tab(t_a_b_s, ' '); string res = ""; bool first = true; if(l_v_l_v_l == 0) res += n_l; res += tab + "["; x1 = min(x1, SIZE(v)), x2 = min(x2, SIZE(v)); auto l = begin(v); advance(l, x1); auto r = l; advance(r, (x2-x1) + (x2 < SIZE(v))); for (auto e = l; e != r; e = next(e)) { if (!first) { res += ", "; } first = false; l_v_l_v_l++; if(e != l){ if(rnk > 1) { res += n_l; t_a_b_s = l_v_l_v_l; }; } else{ t_a_b_s = 0; } res += to_string(*e, coords...); l_v_l_v_l--; } res += "]"; if(l_v_l_v_l == 0) res += n_l; return res; } void debugm(){;} template<typename Heads, typename... Tails> void debugm(Heads H, Tails... T){ cout << to_string(H) << " | "; debugm(T...); }
#define debugm(...) cout << "[DBG]("<<__FUNCTION__<<":"<<__LINE__<<") " << "[" << #__VA_ARGS__ << "]: "; debugm(__VA_ARGS__); cout << endl


double round(double num, int dec) {return std::round(num*pow(10,dec))/pow(10,dec);}
vector<string> split(string s, char delim) {replace(s.begin(),s.end(),delim,' ');stringstream ss(s); string buf;vector<string> v;while (ss>>buf) v.push_back(buf);return v;}
template<typename T, int size> int siz(T(&)[size]){return size;}
template<class T> T gcd(T a,T b){return (b == 0 ? a : gcd(b, a%b));}
template<class T> T lcm(T a, T b ){return a * (b/gcd(a,b));}

/*---------------------------Bitmask------------------------------*/
// 0 index from right
//int setBit(int N, int pos) {return (N | (1<<pos));} // set index to 1
//int clearBit(int N, int pos) {return (N & ~(1<<pos));} // set index to 0
//int toggle(int N, int pos) {return (N ^ (1<<pos));} // toggle bit
//bool check(int N, int pos) {return (bool)(N & (1<<pos));} // check bit
/*----------------------------------------------------------------*/

//priority_queue <int, vector<int>, greater<int>> mq;


template<int V, class T=long long>
class max_flow {
    static const T INF = numeric_limits<T>::max();

    struct edge {
        int t, rev;
        T cap, f;
    };

    vector<edge> adj[V];
    int dist[V];
    int ptr[V];

    bool bfs(int s, int t) {
        memset(dist, -1, sizeof dist);
        dist[s] = 0;
        queue<int> q({ s });
        while (!q.empty() && dist[t] == -1) {
            int n = q.front();
            q.pop();
            for (auto& e : adj[n]) {
                if (dist[e.t] == -1 && e.cap != e.f) {
                    dist[e.t] = dist[n] + 1;
                    q.push(e.t);
                }
            }
        }
        return dist[t] != -1;
    }

    T augment(int n, T amt, int t) {
        if (n == t) return amt;
        for (; ptr[n] < adj[n].size(); ptr[n]++) {
            edge& e = adj[n][ptr[n]];
            if (dist[e.t] == dist[n] + 1 && e.cap != e.f) {
                T flow = augment(e.t, min(amt, e.cap - e.f), t);
                if (flow != 0) {
                    e.f += flow;
                    adj[e.t][e.rev].f -= flow;
                    return flow;
                }
            }
        }
        return 0;
    }

public:
    void add(int u, int v, T cap=1, T rcap=0) {
        adj[u].push_back({ v, (int) adj[v].size(), cap, 0 });
        adj[v].push_back({ u, (int) adj[u].size() - 1, rcap, 0 });
    }

    T calc(int s, int t) {
        T flow = 0;
        while (bfs(s, t)) {
            memset(ptr, 0, sizeof ptr);
            while (T df = augment(s, INF, t))
                flow += df;
        }
        return flow;
    }

    void clear() {
        for (int n = 0; n < V; n++)
            adj[n].clear();
    }
};


// maximum bipartite matching
int main() {
    fastio;
    int n, m, s, v;
    while (cin >> n >> m >> s >> v) {
        vector<pii> gophers;
        f0r (i, n) {
            double a, b; cin >> a >> b;
            int ia = a * 10;
            int ib = b * 10;
            gophers.pb({ia, ib});
        }

        vector<pii> holes;
        f0r (i, m) {
            double a, b; cin >> a >> b;
            int ia = a * 10;
            int ib = b * 10;
            holes.pb({ia, ib});
        }

        // node for source, sink, gophers, and holes
        max_flow<205> network;
        // add source to every gopher
        for (int i = 1; i <= n; i++)
            network.add(0, i, 1);
        // add sink to every hole
        for (int i = n+1; i <= n+m; i++)
            network.add(i, n+m+1, 1);

        for (int i = 0; i < n; i++) {
            for (int j = n; j < n+m; j++) {
                ll dis = (gophers[i].ff - holes[j-n].ff)*(gophers[i].ff - holes[j-n].ff) + (gophers[i].ss - holes[j-n].ss)*(gophers[i].ss - holes[j-n].ss);
                ll lim = 100 * s*v * s*v;
                if (dis <= lim) {
                    network.add(i+1, j+1, 1);
                }
            }
        }

        cout << n - network.calc(0, n+m+1) << endl;
        network.clear();
    }
}
