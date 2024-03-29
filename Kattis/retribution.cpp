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
#define dbg(...) cout << "[DBG]("<<__FUNCTION__<<":"<<__LINE__<<") " << "["<< #__VA_ARGS__ <<"]: "; cout << to_string(__VA_ARGS__) << endl
template <typename T, size_t N> int SIZE(const T (&t)[N]){ return N; } template<typename T> int SIZE(const T &t){ return t.size(); } string to_string(const string s, int x1=0, int x2=1e9){ return '"' + ((x1 < s.size()) ? s.substr(x1, x2-x1+1) : "") + '"'; } string to_string(const char* s) { return to_string((string) s); } string to_string(const bool b) { return (b ? "true" : "false"); } string to_string(const char c){ return string({c}); } template<size_t N> string to_string(const bitset<N> &b, int x1=0, int x2=1e9){ string t = ""; for(int __iii__ = min(x1,SIZE(b)),  __jjj__ = min(x2, SIZE(b)-1); __iii__ <= __jjj__; ++__iii__){ t += b[__iii__] + '0'; } return '"' + t + '"'; } template <typename A, typename... C> string to_string(const A (&v), int x1=0, int x2=1e9, C... coords); int l_v_l_v_l = 0, t_a_b_s = 0; template <typename A, typename B> string to_string(const pair<A, B> &p) { l_v_l_v_l++; string res = "(" + to_string(p.first) + ", " + to_string(p.second) + ")"; l_v_l_v_l--; return res; } template <typename A, typename... C> string to_string(const A (&v), int x1, int x2, C... coords) { int rnk = rank<A>::value; string tab(t_a_b_s, ' '); string res = ""; bool first = true; if(l_v_l_v_l == 0) res += n_l; res += tab + "["; x1 = min(x1, SIZE(v)), x2 = min(x2, SIZE(v)); auto l = begin(v); advance(l, x1); auto r = l; advance(r, (x2-x1) + (x2 < SIZE(v))); for (auto e = l; e != r; e = next(e)) { if (!first) { res += ", "; } first = false; l_v_l_v_l++; if(e != l){ if(rnk > 1) { res += n_l; t_a_b_s = l_v_l_v_l; }; } else{ t_a_b_s = 0; } res += to_string(*e, coords...); l_v_l_v_l--; } res += "]"; if(l_v_l_v_l == 0) res += n_l; return res; } void debugm(){;} template<typename Heads, typename... Tails> void debugm(Heads H, Tails... T){ cout << to_string(H) << " | "; debugm(T...); }
#define dbgm(...) cout << "[DBG]("<<__FUNCTION__<<":"<<__LINE__<<") " << "[" << #__VA_ARGS__ << "]: "; debugm(__VA_ARGS__); cout << endl


double round(double num, int dec) {return std::round(num*pow(10,dec))/pow(10,dec);}
template <typename T> string toString(T x){string s; while (x) {s.push_back(x % 10 + '0'); x /= 10;}reverse(s.begin(), s.end());return s;}
long long toInt(string &x){long long sum = 0; for (int i = 0; i < x.size(); i++) {sum *= 10;sum += (x[i]-'0');}return sum;}
vector<string> split(string s, char delim) {replace(s.begin(),s.end(),delim,' ');stringstream ss(s); string buf;vector<string> v;while (ss>>buf) v.push_back(buf);return v;}
template<typename T, int size> int siz(T(&)[size]){return size;}
template<class T> T gcd(T a,T b){return (b == 0 ? a : gcd(b, a%b));}
template<class T> T lcm(T a, T b ){return a * (b/gcd(a,b));}
template<class T> T binpow(T a, T b) { T res = 1; while (b>0) { if (b&1) res=res*a; a=a*a; b>>=1; } return res; }

/*---------------------------Bitmask------------------------------*/
// 0 index from right
//int setBit(int N, int pos) {return (N | (1<<pos));} // set index to 1
//int clearBit(int N, int pos) {return (N & ~(1<<pos));} // set index to 0
//int toggle(int N, int pos) {return (N ^ (1<<pos));} // toggle bit
//bool check(int N, int pos) {return (bool)(N & (1<<pos));} // check bit
/*----------------------------------------------------------------*/

//priority_queue <int, vector<int>, greater<int>> mq;


struct tri {
    int x;
    int y;
    ll dis;
};

int cmp(tri a, tri b) {
    if (a.dis < b.dis) 
        return 1;
    else if (a.dis > b.dis)
        return 0;
    else if (a.x < b.x)
        return 1;
    else if (a.x > b.x)
        return 0;
    else if (a.y < b.y)
        return 1;
    return 0;
}

bool visA[1005];
bool visB[1005];

int main() {
    fastio;
    int n, m, p; cin >> n >> m >> p;
    vector<pair<int, int>> judges(n);
    vector<pair<int, int>> tars(m);
    vector<pair<int, int>> feathers(p);
    f0r(i, n) cin >> judges[i].ff >> judges[i].ss;
    f0r(i, m) cin >> tars[i].ff >> tars[i].ss;
    f0r(i, p) cin >> feathers[i].ff >> feathers[i].ss;

    // part 1
    vector<tri> pairs;
    f0r(i, n) {
        f0r(j, m) {
            ll dis = (judges[i].ff - tars[j].ff)*(judges[i].ff - tars[j].ff) + (judges[i].ss - tars[j].ss)*(judges[i].ss - tars[j].ss);
            pairs.pb({i, j, dis});
        }
    }
    sort(all(pairs), cmp);

    MEM(visA, false);
    MEM(visB, false);
    double ans = 0;
    
    f0r(i, pairs.size()) {
        if (visA[pairs[i].x] || visB[pairs[i].y])
            continue;
        visA[pairs[i].x] = true;
        visB[pairs[i].y] = true;
        ans += sqrt(pairs[i].dis);
    }

    // part 2
    pairs.clear();
    f0r(i, n) {
        f0r(j, p) {
            ll dis = (judges[i].ff - feathers[j].ff)*(judges[i].ff - feathers[j].ff) + (judges[i].ss - feathers[j].ss)*(judges[i].ss - feathers[j].ss);
            pairs.pb({i, j, dis});
        }
    }
    sort(all(pairs), cmp);
    //for(auto val : pairs) {
        //dbg(val.x);
        //dbg(val.y);
        //dbg(val.dis);
    //}

    MEM(visA, false);
    MEM(visB, false);
    
    f0r(i, pairs.size()) {
        if (visA[pairs[i].x] || visB[pairs[i].y])
            continue;
        visA[pairs[i].x] = true;
        visB[pairs[i].y] = true;
        ans += sqrt(pairs[i].dis);
    }
    printf("%.7lf\n", ans);
}
