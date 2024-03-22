#include <string>
#include <vector>
#include <queue>

using namespace std;

bool visit[205];
int cnt = 0, N;
vector<vector<int>> c;

void bfs(int i){
    cnt++;
    queue<int> q;
    q.push(i); visit[i] = 1;
    
    while(!q.empty()){
        int x = q.front(); q.pop();
        for(int y = 0; y < N; y++){
            if(x == y || visit[y]) continue;
            if(c[x][y] == 1) {
                visit[y] = 1;
                q.push(y);
            }
        }
    }
}


int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    c = computers;
    N = n;
    
    for(int i = 0; i < n; i++){
        if(!visit[i]) bfs(i); 
    }
    
    return cnt;
}