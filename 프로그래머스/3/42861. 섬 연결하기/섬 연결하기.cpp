#include <string>
#include <vector>
#include <algorithm>
#include <tuple>
#define MX 105
using namespace std;

int answer = 0, cnt = 0;
int p[MX], rk[MX];
vector<tuple<int,int,int>> edges;

int find(int x){
    if(p[x] == x) return x;
    return p[x] = find(p[x]);
}

void union_by_rank(int x, int y, int z){
    x = find(x);
    y = find(y);
    if(x == y) return;
    if(rk[x] < rk[y]) swap(x,y);
    p[y] = x;
    if(rk[x] == rk[y]) rk[x]++;
    answer += z; cnt++;
}

int solution(int n, vector<vector<int>> costs) {
    for(int i = 1; i <= n; i++){
        p[i] = i; rk[i] = 1;
    }
    for(auto c: costs) edges.push_back(tie(c[2], c[0], c[1]));
    sort(edges.begin(), edges.end());
    
    for(auto e: edges){
        int u,v,w;
        tie(w,u,v) = e;
        union_by_rank(u,v,w);
        if(cnt == n - 1) break;
    }
    
    return answer;
}