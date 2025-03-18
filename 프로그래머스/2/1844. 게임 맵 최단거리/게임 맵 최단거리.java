import java.util.*;

class Solution {
    int[] dx = { -1, 0, 1, 0};
    int[] dy = { 0, -1, 0, 1};
    
    public int solution(int[][] maps) {
        int n = maps.length, m = maps[0].length;
        int answer = Integer.MAX_VALUE;
        boolean[][] v = new boolean[n][m];
        
        Queue<ROR> q = new LinkedList<>();
        q.add(new ROR(0,0,0));       
        v[0][0] = true;
        
        while(!q.isEmpty()){
            ROR cur = q.poll();
            if(cur.x == n - 1 && cur.y == m - 1) {
                if(cur.cnt < answer) answer = cur.cnt + 1;
            }
            
            for(int d = 0; d < 4; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(maps[nx][ny] == 0 || v[nx][ny]) continue;
                v[nx][ny] = true;
                q.add(new ROR(nx, ny, cur.cnt + 1));
            }
        }
        
        return (answer == Integer.MAX_VALUE) ? -1 : answer;
    }
}

class ROR{
    public int x; 
    public int y;
    public int cnt;
    
    ROR(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}