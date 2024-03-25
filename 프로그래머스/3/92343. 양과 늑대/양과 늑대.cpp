#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> adj[18];
vector<int> info2;
vector<bool> vis((1<<18), 0);
int ans, n;

void dfs(int bit){
    if(vis[bit]) return;
    vis[bit] = 1;
    
    int wolf = 0, cnt = 0;
    for(int i = 0; i < n; i++){
        if((1 << i) & bit) {
            cnt++;
            wolf += info2[i];
        }
    }

    if(wolf >= cnt - wolf) return;
    ans = max(ans, cnt - wolf);
    
    for(int i = 0; i < n; i++){
        if(!(bit & (1 << i))) continue;
        for(auto nx : adj[i]) {
            int nbit = (bit | (1 << nx));
            dfs(nbit);
        }
    }
}

int solution(vector<int> info, vector<vector<int>> edges) {
    n = info.size();
    info2 = info;
    for(auto e: edges) adj[e[0]].push_back(e[1]);
   
    dfs(1);
    return ans;
}