#include <string>
#include <vector>
#include <queue>
#include <tuple>
#include <iostream>

#define MX 105
#define X first
#define Y second
using namespace std;

int arr[MX][MX], w = 0;
int dx[4] = {-1,0,1,0}, dy[4] = {0,-1,0,1};

bool inRect(vector<vector<int>> &rect, int a, int b){
    for(auto r : rect)
        if(a > r[0] && a < r[2] && b > r[1] && b < r[3]) return 1;
    
    return 0;
}

int solution(vector<vector<int>> rect, int cx, int cy, int ix, int iy) {
    int sz = rect.size();
    
    for(int i = 0; i < sz; i++){
        for(int j = 0; j < 4; j++) rect[i][j] *= 2;
        int lx = rect[i][0];
        int ly = rect[i][1];
        int rx = rect[i][2];
        int ry = rect[i][3];
        for(int j = lx; j <= rx; j++)
            for(int k = ly; k <= ry; k++)
                arr[j][k] = -1;
    }
    
    cx *= 2;
    cy *= 2;
    ix *= 2;
    iy *= 2;
    
    queue<tuple<int,int,int>> q;
    q.push({cx, cy, 0});
    
    while(!q.empty()){
        tie(cx, cy, w) = q.front(); q.pop();
        if(cx == ix && cy == iy) return w/ 2;
        arr[cx][cy] = w;
        for(int i = 0; i < 4; i++){
            int nx = cx + dx[i], ny = cy + dy[i];
            if(arr[nx][ny] < 0 && !inRect(rect, nx, ny)){
                q.push({nx, ny, w + 1});
            }
        }
    }
    
    
    return -1;
}