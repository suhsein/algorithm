#include <string>
#include <vector>
#include <iostream>
#define ll long long
using namespace std;


bool chk(ll m, int& n, vector<int> &times){
    ll cnt = 0;
    for(auto t : times){
        cnt += m / t;
        if(cnt >= n) return 0;
    }
    return 1;
}

long long solution(int n, vector<int> times) {
    ll l = -1, r = 1e18, m;
    while(l + 1 < r){
        m = (l + r) / 2;
        if(!chk(m, n, times)) r = m;
        else l = m;
    }
    return l + 1;
}