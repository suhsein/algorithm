#include <string>
#include <vector>
#include <algorithm>
#define ll long long

using namespace std;

int n;
bool chk(ll &m, int &a, int &b, vector<int> &g, vector<int> &s, vector<int> &w, vector<int> &t){
    ll sum_w = 0, sum_g = 0, sum_s = 0;
    
    for(int i = 0; i < n; i++){
        ll cnt = m / (t[i] * 2); // 왕복
        if(m % (t[i] * 2) >= t[i]) cnt++; // 편도 한 번 더 가능
        
        ll max_w = min((ll)cnt * w[i], (ll)g[i] + s[i]);
        sum_w += max_w;
        sum_g += min((ll)max_w, (ll)g[i]);
        sum_s += min((ll)max_w, (ll)s[i]);
    }
    return (sum_w >= a + b && sum_g >= a && sum_s >= b);
}
long long solution(int a, int b, vector<int> g, vector<int> s, vector<int> w, vector<int> t) {
    n = g.size();
    
    ll st = 0, en = 4e14, m = 0;
    while(st < en){
        m = (st+en)/2;
        if(chk(m, a, b, g, s, w, t)) en = m;
        else st = m + 1;
    }
    return en;
}