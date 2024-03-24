#include <string>
#include <vector>
#include <queue>
#define X first
#define Y second

using namespace std;

vector<vector<int>> table2, game_board2;
vector<vector<vector<int>>> puzzle_p, board_p;
vector<bool> visit;
int dx[4] = {-1,0,1,0}, dy[4] = {0,-1,0,1};
int n;

void split_pieces(int a, int b, vector<vector<int>> &t, 
                  vector<vector<int>> &t2, 
                  bool is_pz){
    queue<pair<int,int>> q;
    q.push({a,b}); t2[a][b] = 0;
    
    int sr = a, er = a, sc = b, ec = b;
    
    while(!q.empty()){
        auto cur = q.front(); q.pop();
        int x = cur.X, y = cur.Y;
        
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i], ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if(t2[nx][ny] != is_pz) continue;
            t2[nx][ny] = !is_pz; q.push({nx,ny});
            
            if(nx < sr) sr = nx;
            if(ny < sc) sc = ny;
            if(nx > er) er = nx;
            if(ny > ec) ec = ny;
        }
    }
    
    vector<vector<int>> v;
    
    for(int i = sr; i <= er; i++){
        vector<int> r;
        for(int j = sc; j <= ec; j++) {
            if(is_pz) r.push_back(t[i][j]);
            else r.push_back(!t[i][j]);
        }
        v.push_back(r);
    }
    if(is_pz) puzzle_p.push_back(v);
    else board_p.push_back(v);
}

vector<vector<int>> rotate_p(vector<vector<int>> cur){
    int r = cur.size(), c = cur[0].size();
    vector<vector<int>> ret(c, vector<int>(r, 0));
    for(int i = 0; i < r; i++){
        for(int j = 0; j < c; j++){
            ret[j][i] = cur[r - i - 1][j];
        }
    }
    return ret;
}

int comp_cnt(int &br, int &bc, vector<vector<int>> &bp, vector<vector<int>> &pp){
    int cnt = 0;
    for(int i = 0; i < br; i++){
        for(int j = 0; j < bc; j++) {
            if(bp[i][j] != pp[i][j]) return 0;
            if(bp[i][j] == 1) cnt++;
        }   
    }
    return cnt;
}

int compare_p(vector<vector<int>> &bp, vector<vector<int>> pp, int idx){
    int br = bp.size(), bc = bp[0].size();
    int pr = pp.size(), pc = pp[0].size(), cnt = 0;
    
    if(br == pr && bc == pc){
        if(br == bc) { // 정사각형 -> 0 ~ 3 회전 비교
            for(int i = 0; i < 4; i++) {
                if(i > 0) pp = rotate_p(pp);
                cnt = comp_cnt(br, bc, bp, pp);
                if(cnt) {
                    visit[idx] = 1;
                    return cnt;
                }
            }
        } else {
            cnt = comp_cnt(br, bc, bp, pp); // 0 회전
            if(cnt) {
                visit[idx] = 1;
                return cnt;
            }
            pp = rotate_p(rotate_p(pp)); // 2 회전
            cnt = comp_cnt(br, bc, bp, pp);
        }
    } else {
        if(br != pc || bc != pr) return 0; // 1 회전 해도 안됨 -> 불가능
        pp = rotate_p(pp); // 1 회전
        cnt = comp_cnt(br, bc, bp, pp);
        if(cnt) {
            visit[idx] = 1;
            return cnt;
        }
        pp = rotate_p(rotate_p(pp)); // 3 회전
        cnt = comp_cnt(br, bc, bp, pp);
    }
    
    if(cnt) visit[idx] = 1;
    return cnt;
}

int solution(vector<vector<int>> game_board, vector<vector<int>> table) {
    n = table.size();
    game_board2 = game_board;
    table2 = table;
    int answer = 0;
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(table2[i][j]) split_pieces(i, j, table, table2, 1);
            if(!game_board2[i][j]) split_pieces(i, j, game_board, game_board2, 0);
        } 
    }    
    
    visit.resize(puzzle_p.size(), 0);
    int idx = 0;
    
    for(auto bp : board_p){
        idx = 0;
        for(auto pp : puzzle_p){
            if(visit[idx++]) continue;
            int tmp = compare_p(bp, pp, idx-1);
            answer += tmp;
            if(tmp) break;
        }
    }
    
    
    return answer;
}