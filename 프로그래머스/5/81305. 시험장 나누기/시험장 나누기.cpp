#include <string>
#include <vector>
#include <algorithm>
#define MX 10005
using namespace std;

int N, root;
int l[MX], r[MX], x[MX], p[MX];

int dfs(int cur, int lim, int &cnt){
    int lv = 0, rv = 0;
    if(l[cur] != -1) lv = dfs(l[cur], lim, cnt);
    if(r[cur] != -1) rv = dfs(r[cur], lim, cnt);
    if(x[cur] + lv + rv <= lim) return x[cur] + lv + rv;
    if(x[cur] + min(lv, rv) <= lim) {
        cnt++;
        return x[cur] + min(lv,rv);
    }
    cnt += 2;
    return x[cur];
}
int search(int lim){
    int cnt = 0;
    dfs(root, lim, cnt);
    return cnt + 1;
}
int solution(int k, vector<int> num, vector<vector<int>> links) {
    int st = 0, en = 0, m;
    N = num.size();
    fill(p, p + N, -1);
    
    for(int i = 0; i < N; i ++){
        l[i] = links[i][0]; r[i] = links[i][1];
        x[i] = num[i]; en += num[i];
        if(l[i] != -1) p[l[i]] = i;
        if(r[i] != -1) p[r[i]] = i;
    }
    for(int i = 0; i < N; i++) {
        if(p[i] == -1) {
            root = i;
            break;
        }
    }
    st= *max_element(x, x+N);
    en++;
    while(st<en){
        m = (st+en)/2;
        if(search(m) <= k) en = m;
        else st = m + 1;
    }
    return en;
}