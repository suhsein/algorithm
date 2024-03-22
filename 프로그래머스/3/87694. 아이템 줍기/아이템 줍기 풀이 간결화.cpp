#include <string>
#include <vector>
#include <queue>
#include <tuple>
#define MX 105
using namespace std;

int arr[MX][MX], w;
int dx[4] = {-1,0,1,0}, dy[4] = {0,-1,0,1};

bool inRect(vector<vector<int>> &rect, int a, int b){
    for(auto r : rect)
        if(a > r[0] && a < r[2] && b > r[1] && b < r[3]) return 1;
    return 0;
}

int solution(vector<vector<int>> rect, int cx, int cy, int ix, int iy) {
    int answer = 0, sz = rect.size();
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
    
    queue<pair<int,int>> q;
    q.push({cx, cy});
    arr[cx][cy] = 0;
    
    while(!q.empty()){
        tie(cx, cy) = q.front(); q.pop();
        for(int i = 0; i < 4; i++){
            int nx = cx + dx[i], ny = cy + dy[i];
            if(arr[nx][ny] >= 0 || inRect(rect, nx, ny)) continue;
            arr[nx][ny] = arr[cx][cy] + 1;
            if(nx == ix && ny == iy) return arr[nx][ny] / 2;
            q.push({nx,ny});
        }
    }
}
