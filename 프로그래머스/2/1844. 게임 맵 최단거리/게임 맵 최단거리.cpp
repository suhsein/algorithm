#include<vector>
#include <queue>
#define MX 105
#define X first
#define Y second
using namespace std;

int arr[MX][MX];
int dx[4] = {-1,0,1,0}, dy[4] = {0,-1,0,1};

int solution(vector<vector<int>> maps)
{   
    queue<pair<int,int>> q;
    int n = maps.size(), m = maps[0].size();
    for(int i = 0; i < n; i++) fill(arr[i], arr[i]+m, -1);
    
    q.push({0,0});
    arr[0][0] = 1;
    
    while(!q.empty()){
        auto cur = q.front(); q.pop();
        int x = cur.X, y = cur.Y;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i], ny = y + dy[i];
            if(nx == n-1 && ny == m-1) return arr[x][y] + 1;
            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(arr[nx][ny] != -1 || maps[nx][ny] == 0) continue;
            arr[nx][ny] = arr[x][y] + 1;
            q.push({nx, ny});
        }
    }

    return -1;
}