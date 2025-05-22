class Solution {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int answer;
    static int n, m;
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        n = board.length;
        m = board[0].length;
        
        return solve(board, aloc[0], aloc[1], bloc[0], bloc[1]).cnt;
    }
    
    public class Result {
        public boolean isWin;
        public int cnt;
        
        public Result(boolean isWin, int cnt){
            this.isWin = isWin;
            this.cnt = cnt;
        }
    }
    
    public boolean canMove(int[][] board, int x, int y) {
        int nx, ny;
        
        for(int d = 0; d < 4; d++){
            nx = x + dx[d];
            ny = y + dy[d];
            if(!OOB(board, nx,ny)) return true;
        }
        
        return false;
    }
    
    public boolean OOB(int[][] board, int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m || board[x][y] == 0;
    }
    
    public Result solve(int[][] board, int mx, int my, int ox, int oy) {
        if(!canMove(board, mx, my)) 
            return new Result(false, 0);   
        
        if(mx == ox && my == oy) 
            return new Result(true, 1);
        
        int nx, ny;
        boolean canWin = false;
        int minCnt = Integer.MAX_VALUE, maxCnt = -1;
        
        board[mx][my] = 0;
        
        for(int d = 0; d < 4; d++) {
            nx = mx + dx[d];
            ny = my + dy[d];

            if(OOB(board, nx, ny)) continue;
            
            Result nxtResult = solve(board, ox, oy, nx, ny);
            if(nxtResult.isWin) { // 상대 플레이어가 이김 -> 현재 플레이어 최대한 도망다니기
               if(maxCnt < nxtResult.cnt) maxCnt = nxtResult.cnt;
            } else { // 현재 플레이어가 이김 -> 빨리 게임 끝내기
                canWin = true;
                if(minCnt > nxtResult.cnt) minCnt = nxtResult.cnt;
            }
        }
        
        board[mx][my] = 1;
        
        return new Result(canWin, (canWin ? minCnt : maxCnt) + 1);
    }

}