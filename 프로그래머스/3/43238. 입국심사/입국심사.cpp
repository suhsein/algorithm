#include <string>
#include <vector>
#define ll long long
using namespace std;

bool chk(int &n, ll &m, vector<int> &times){
    ll cnt = 0;
    for(auto t: times) {
        cnt += m / t;
        if(cnt >= n) return 1;
    }
    return 0;
}

ll solution(int n, vector<int> times) {
    ll l = 0, r = 1e9 * n, m;
    while(l < r){
        m = (l+r)/2;
        if(chk(n,m,times)) r = m;
        else l = m + 1;
    }
    
    return r;
}