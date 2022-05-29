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


// kosaraju's algorithm

int n, m;
bool vis[50];
vector<vi> adj;
vector<vi> adjRev;
vector<int> order;
vector<pii> edges;

void dfs1(int node, int u, int v) {
    vis[node] = true;
    if (node == v) {
        if (!vis[u]) 
            dfs1(u, u, v);
    }
    for (int child : adj[node]) {
        if (node == u && child == v)
            continue;
        if (!vis[child])
            dfs1(child, u, v);
    }
    order.pb(node);
}

void dfs2(int node, int u, int v) {
    vis[node] = true;
    if (node == v) {
        if (!vis[u])
            dfs2(u, u, v);
    }
    for (int child : adjRev[node]) {
        if (node == u && child == v)
            continue;
        if (!vis[child])
            dfs2(child, u, v);
    }
}

bool invalid(int u, int v) {
    for (int i = 0; i < n; i++)
        if (!vis[i])
            dfs1(i, u, v);

    reverse(all(order));
    int numComp = 0;
    MEM(vis, false);

    for (int x : order) {
        if (!vis[x]) {
            numComp++;
            dfs2(x, v, u);
        }
    }

    return (numComp > 1);
}

int main() {
    fastio;
    int cases = 0;
    while (cin >> n >> m) {
        cases++;
        adj.clear();
        adjRev.clear();
        adj.resize(n);
        adjRev.resize(n);
        MEM(vis, false);
        order.clear();
        edges.clear();
        edges.pb({-1, -1});

        f0r (i, m) {
            int u, v; cin >> u >> v;
            adj[u].pb(v);
            adjRev[v].pb(u);
            edges.pb({u, v});
        }

        bool bad = true;
        f0r (i, m+1) {
            MEM(vis, false);
            order.clear();
            bool res = invalid(edges[i].ff, edges[i].ss);
            if (!res && i == 0) {
                bad = false;
                cout << "Case " << cases << ": valid\n";
                break;
            } else if (!res) {
                bad = false;
                cout << "Case " << cases << ": " << edges[i].ff << " " << edges[i].ss << endl;
                break;
            }
        }
        if (bad)
            cout << "Case " << cases << ": invalid\n";
    }
}
