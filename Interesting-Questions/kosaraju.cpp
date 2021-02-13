// Cantina of Babel ICPC NAQ

  #ifndef _GLIBCXX_NO_ASSERT
  #include <cassert>
  #endif
  #include <cctype>
  #include <cerrno>
  #include <cfloat>
  #include <ciso646>
  #include <climits>
  #include <clocale>
  #include <cmath>
  #include <csetjmp>
  #include <csignal>
  #include <cstdarg>
  #include <cstddef>
  #include <cstdio>
  #include <cstdlib>
  #include <cstring>
  #include <ctime>

  #if __cplusplus >= 201103L
  #include <ccomplex>
  #include <cfenv>
  #include <cinttypes>
  #include <cstdbool>
  #include <cstdint>
  #include <ctgmath>
  #include <cwchar>
  #include <cwctype>
  #endif

  // C++
  #include <algorithm>
  #include <bitset>
  #include <complex>
  #include <deque>
  #include <exception>
  #include <fstream>
  #include <functional>
  #include <iomanip>
  #include <ios>
  #include <iosfwd>
  #include <iostream>
  #include <istream>
  #include <iterator>
  #include <limits>
  #include <list>
  #include <locale>
  #include <map>
  #include <memory>
  #include <new>
  #include <numeric>
  #include <ostream>
  #include <queue>
  #include <set>
  #include <sstream>
  #include <stack>
  #include <stdexcept>
  #include <streambuf>
  #include <string>
  #include <typeinfo>
  #include <utility>
  #include <valarray>
  #include <vector>

  #if __cplusplus >= 201103L
  #include <array>
  #include <atomic>
  #include <chrono>
  #include <condition_variable>
  #include <forward_list>
  #include <future>
  #include <initializer_list>
  #include <mutex>
  #include <random>
  #include <ratio>
  #include <regex>
  #include <scoped_allocator>
  #include <system_error>
  #include <thread>
  #include <tuple>
  #include <typeindex>
  #include <type_traits>
  #include <unordered_map>
  #include <unordered_set>
  #endif
using namespace std;

#define MEM(a, b) memset(a, (b), sizeof(a))
#define repn(i, a, n) for (int i = a; i < n; i++)
#define revn(i, a, n) for (int i = a; i > n; i--)
#define rep(i, n) for (int i = 0; i < n; i++)
#define rev(i, a) for (int i = a; i > -1; i--)
#define mp make_pair
#define pb push_back
#define ff first
#define ss second
#define vc vector
#define INF 1000000010
#define LLINF 1000000000000000010;
#define MOD 1000000007 // 998244353 1000000007
#define PI 3.141592653589793238462643383279502884197169399375105820974945
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

//debugging output in cerr
#define n_l '\n'
#define debug(...) cout << "[" << #__VA_ARGS__ << "]: "; cout << to_string(__VA_ARGS__) << endl
template <typename T, size_t N> int SIZE(const T (&t)[N]){ return N; } template<typename T> int SIZE(const T &t){ return t.size(); } string to_string(const string s, int x1=0, int x2=1e9){ return '"' + ((x1 < s.size()) ? s.substr(x1, x2-x1+1) : "") + '"'; } string to_string(const char* s) { return to_string((string) s); } string to_string(const bool b) { return (b ? "true" : "false"); } string to_string(const char c){ return string({c}); } template<size_t N> string to_string(const bitset<N> &b, int x1=0, int x2=1e9){ string t = ""; for(int __iii__ = min(x1,SIZE(b)),  __jjj__ = min(x2, SIZE(b)-1); __iii__ <= __jjj__; ++__iii__){ t += b[__iii__] + '0'; } return '"' + t + '"'; } template <typename A, typename... C> string to_string(const A (&v), int x1=0, int x2=1e9, C... coords); int l_v_l_v_l = 0, t_a_b_s = 0; template <typename A, typename B> string to_string(const pair<A, B> &p) { l_v_l_v_l++; string res = "(" + to_string(p.first) + ", " + to_string(p.second) + ")"; l_v_l_v_l--; return res; } template <typename A, typename... C> string to_string(const A (&v), int x1, int x2, C... coords) { int rnk = rank<A>::value; string tab(t_a_b_s, ' '); string res = ""; bool first = true; if(l_v_l_v_l == 0) res += n_l; res += tab + "["; x1 = min(x1, SIZE(v)), x2 = min(x2, SIZE(v)); auto l = begin(v); advance(l, x1); auto r = l; advance(r, (x2-x1) + (x2 < SIZE(v))); for (auto e = l; e != r; e = next(e)) { if (!first) { res += ", "; } first = false; l_v_l_v_l++; if(e != l){ if(rnk > 1) { res += n_l; t_a_b_s = l_v_l_v_l; }; } else{ t_a_b_s = 0; } res += to_string(*e, coords...); l_v_l_v_l--; } res += "]"; if(l_v_l_v_l == 0) res += n_l; return res; } void debugm(){;} template<typename Heads, typename... Tails> void debugm(Heads H, Tails... T){ cout << to_string(H) << " | "; debugm(T...); }
#define debugm(...) cout << "[" << #__VA_ARGS__ << "]: "; debugm(__VA_ARGS__); cout << endl

double round(double num, int dec) {return std::round(num*pow(10,dec))/pow(10,dec);}
template <typename T> string toString(T x){string s; while (x) {s.push_back(x % 10 + '0'); x /= 10;}reverse(s.begin(), s.end());return s;}
long long toInt(string &x){long long sum = 0; for (int i = 0; i < x.size(); i++) {sum *= 10;sum += (x[i]-'0');}return sum;}
vector<string> split(string s, char delim) {replace(s.begin(),s.end(),delim,' ');stringstream ss(s); string buf;vector<string> v;while (ss>>buf) v.push_back(buf);return v;}
template<typename T, int size> int siz(T(&)[size]){return size;}
template<class T> T POW(T base, T exp) {long long res = 1;while (exp > 0) {if (exp % 2 == 1){res= (res * base) % MOD;}exp = exp >> 1;base = (base * base) % MOD;}return res;}
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

void dfs1(string node, unordered_map<string, pair<int, vs>>& m, unordered_set<string>& vis, stack<string>& stk) {
    if (vis.count(node) > 0)
        return;
    vis.insert(node);
    for (auto child : m[node].ss)
        dfs1(child, m, vis, stk);
    stk.push(node);
}

void dfs2(string node, unordered_map<string, pair<int, vs>>& m, unordered_set<string>& vis, vs& components) {
    if (vis.count(node) > 0)
        return;
    vis.insert(node);

    components.pb(node);
    for (auto child : m[node].ss)
        dfs2(child, m, vis, components);
}

int main() {
    int n; cin >> n;

    unordered_map<string, pair<int, vs>> m1;
    unordered_map<string, pair<int, vs>> m2;
    unordered_set<string> langs;

    rep(i, n) {
        string name, lang, listens;
        cin >> name >> lang;

        langs.insert(lang);
        m1[lang].ff++;
        m2[lang].ff++;

        while (cin.peek() != '\n') {
            cin >> listens;
            m1[lang].ss.pb(listens);
            m2[listens].ss.pb(lang);
        }

    }
    stack<string> stk;
    unordered_set<string> vis;
    for (auto i : langs) {
        if (vis.count(i) > 0) continue;
        dfs1(i, m1, vis, stk);
    }

    int largestGroup = 0;
    vis.clear();
    while (!stk.empty()) {
        string curr = stk.top();
        stk.pop();

        if (vis.count(curr) > 0) continue;

        vs components;
        dfs2(curr, m2, vis, components);
        int temp = 0;
        for (auto i : components)
            temp += m1[i].ff;
        largestGroup = max(temp, largestGroup);
    }
    cout << n - largestGroup << endl;
}

/*
6
Fran French Italian
Enid English German
George German Italian
Ian Italian French Spanish
Spencer Spanish Portugese
Polly Portugese Spanish

*/
