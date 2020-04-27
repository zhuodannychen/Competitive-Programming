/*
    We will consider a small tree.     X
                                      / \
                                     Y   Z
    Case 1:
    If X is black, then Y and Z have to be white. (All of the children have to be white)
    Therefore, dfs(X, black) = dfs(Y, white) * dfs(Z, white).
    Rule of product

    Case 2:
    If X is white, then Y could be black, or Z could be black, or both.
    Therefore, dfs(X, white) = (dfs(Y, white) + dfs(Y, black)) * (dfs(Z, white) + dfs(Z, black))
    
    The answer is the dfs(root, white) + dfs(root, black)
*/
#include <bits/stdc++.h>
using namespace std;

#define MEM(a, b) memset(a, (b), sizeof(a))
#define FORN(i, a, n) for (int i = a; i < n; i++)
#define FRON(i, a, n) for (int i = a; i > n; i--)
#define FOR(i, n) for (int i = 0; i < n; i++)
#define FRO(i, a) for (int i = a; i > 0; i--)
#define MP make_pair
#define PB push_back
#define INF 1000000010
#define MOD 1000000007 // 998244353
#define PI 3.141592653589793238462643383279502884197169399375105820974945
#define FASTIO ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
typedef long long ll;
typedef vector<int> VI;
typedef vector<ll> VL;
typedef pair<int, int> PII;
typedef vector<string> VS;
typedef vector<VI> VII;

//debugging
#define n_l '\n'
#define debug(...) cout << "[" << #__VA_ARGS__ << "]: "; cout << to_string(__VA_ARGS__) << endl
template <typename T, size_t N> int SIZE(const T (&t)[N]){ return N; } template<typename T> int SIZE(const T &t){ return t.size(); } string to_string(const string s, int x1=0, int x2=1e9){ return '"' + ((x1 < s.size()) ? s.substr(x1, x2-x1+1) : "") + '"'; } string to_string(const char* s) { return to_string((string) s); } string to_string(const bool b) { return (b ? "true" : "false"); } string to_string(const char c){ return string({c}); } template<size_t N> string to_string(const bitset<N> &b, int x1=0, int x2=1e9){ string t = ""; for(int __iii__ = min(x1,SIZE(b)),  __jjj__ = min(x2, SIZE(b)-1); __iii__ <= __jjj__; ++__iii__){ t += b[__iii__] + '0'; } return '"' + t + '"'; } template <typename A, typename... C> string to_string(const A (&v), int x1=0, int x2=1e9, C... coords); int l_v_l_v_l = 0, t_a_b_s = 0; template <typename A, typename B> string to_string(const pair<A, B> &p) { l_v_l_v_l++; string res = "(" + to_string(p.first) + ", " + to_string(p.second) + ")"; l_v_l_v_l--; return res; } template <typename A, typename... C> string to_string(const A (&v), int x1, int x2, C... coords) { int rnk = rank<A>::value; string tab(t_a_b_s, ' '); string res = ""; bool first = true; if(l_v_l_v_l == 0) res += n_l; res += tab + "["; x1 = min(x1, SIZE(v)), x2 = min(x2, SIZE(v)); auto l = begin(v); advance(l, x1); auto r = l; advance(r, (x2-x1) + (x2 < SIZE(v))); for (auto e = l; e != r; e = next(e)) { if (!first) { res += ", "; } first = false; l_v_l_v_l++; if(e != l){ if(rnk > 1) { res += n_l; t_a_b_s = l_v_l_v_l; }; } else{ t_a_b_s = 0; } res += to_string(*e, coords...); l_v_l_v_l--; } res += "]"; if(l_v_l_v_l == 0) res += n_l; return res; } void debugm(){;} template<typename Heads, typename... Tails> void debugm(Heads H, Tails... T){ cout << to_string(H) << " | "; debugm(T...); } 
#define debugm(...) cout << "[" << #__VA_ARGS__ << "]: "; debugm(__VA_ARGS__); cout << endl

double round(double num, int dec) {return std::round(num*pow(10,dec))/pow(10,dec);}
vector<string> split(string s, char delim) {replace(s.begin(),s.end(),delim,' ');stringstream ss(s); string buf;vector<string> v;while (ss>>buf) v.push_back(buf);return v;}
template<typename T, int size> int siz(T(&)[size]){return size;}
// need to define arrays (fact, inv, finv) here to use.
/*
const int MAXN = 10;
long long fact[MAXN], inv[MAXN], finv[MAXN];
void buildfact(int n) {fact[0] = finv[0] = inv[1] = 1;for(int i = 2; i < n; i++){inv[i] = (MOD - (MOD / i) * inv[MOD%i] % MOD) % MOD;}for(int i = 1; i < n; i++){fact[i] = fact[i-1] * i % MOD;finv[i] = finv[i-1] * inv[i] % MOD;}}
long long nCr(int a,int b){if(a < b || b < 0)return 0; return fact[a] * finv[b] % MOD * finv[a-b] % MOD;}
*/



ll dp[100005][2];
vector<int> adj[100005];

// color 0 - black, 1 - white
ll dfs(int node, int parent, int color) {
    if (dp[node][color] != -1)
        return dp[node][color];
    dp[node][color] = 1;

    for (auto child : adj[node]) {
        if (child != parent) {
            ll subtrees_cnt = 1;
            if (color == 0)
                subtrees_cnt = dfs(child, node, 1);
            else if (color == 1)
                subtrees_cnt = (dfs(child, node, 0) + dfs(child, node, 1)) % MOD;
            dp[node][color] = (dp[node][color] * subtrees_cnt) % MOD;
        }
    }
    return dp[node][color];
}

int main() {
    FASTIO;
    int n; cin >> n;
    MEM(dp, -1);
    for (int i = 0; i < n-1; i++) {
        int u, v;
        cin >> u >> v;
        --u; --v;
        adj[u].PB(v);
        adj[v].PB(u);
    }
    ll ans1 = dfs(0, -10, 0);
    ll ans2 = dfs(0, -10, 1);
    cout << (ans1 + ans2) % MOD << "\n";
}
