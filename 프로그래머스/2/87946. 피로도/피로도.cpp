#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<bool> v;
vector<vector<int>> d;
int ans = 0, sz = 0;

void dfs(int tk, int cnt){
    bool flag = 1;
    for(int i = 0; i < sz; i++) {
        if(!v[i]) {
            flag = 0;
            break;
        }
    }
    if(flag){
        if(cnt > ans) ans = cnt;
        return;
    }
    
    for(int i = 0; i < sz; i++){
        if(v[i]) continue;
        v[i] = 1;
        if(tk >= d[i][0]) dfs(tk - d[i][1], cnt + 1);
        else dfs(tk, cnt);
        v[i] = 0;
    }
}

int solution(int k, vector<vector<int>> dungeons) {
    d = dungeons;
    sz = dungeons.size();
    v.resize(sz, 0);
    
    dfs(k, 0);
    
    return ans;
}