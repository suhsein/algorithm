import java.util.*;

class Solution {
    public static int MX = 105;
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, -1, 0, 1 };
    
    public int solution(int[][] rectangle, int cx, int cy, int ix, int iy) {
        int[][] f = new int[MX][MX];
        
        
        for(int[] r : rectangle) {
            for(int i = 0; i < 4; i++) r[i] *= 2;
            for(int i = r[0]; i <= r[2]; i++) 
                for(int j = r[1]; j <= r[3]; j++) 
                    f[i][j] = -1;
        }
        
        cx *= 2;
        cy *= 2;
        ix *= 2;
        iy *= 2;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(cx, cy));
        f[cx][cy] = 0;
        
        while(!q.isEmpty()){
            Pair cur = q.poll();
            
            for(int d = 0; d < 4; d++){
                int nx = cur.x + dx[d], ny = cur.y + dy[d];
                
                if(inRect(nx, ny, rectangle) || f[nx][ny] >= 0) continue;
                f[nx][ny] = f[cur.x][cur.y] + 1;
                
            
                if(nx == ix && ny == iy) return f[nx][ny] / 2;
                q.add(new Pair(nx, ny));
            }
        }
        
        return 0;
    }
    
    public boolean inRect(int a, int b, int[][]rectangle){
        for(int[] r : rectangle)
            if(a > r[0] && a < r[2] && b > r[1] && b < r[3]) return true;
        
        return false;
    }
}

class Pair {
    public int x;
    public int y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}