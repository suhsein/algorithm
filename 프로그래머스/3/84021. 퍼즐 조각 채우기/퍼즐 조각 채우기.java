import java.util.*;


class Solution {
    boolean[][] visit;
    int N;
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    List<Piece> boardPieces = new ArrayList<>();
    List<Piece> puzzlePieces = new ArrayList<>();
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        
        N = game_board.length;
        visit = new boolean[N][N];
        
        // 조각 분리
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(game_board[i][j] == 0 && !visit[i][j]) 
                    splitPieces(new int[] {i, j}, 0, visit, game_board, boardPieces);
            }
        }
        
        visit = new boolean[N][N];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(table[i][j] == 1 && !visit[i][j]) 
                    splitPieces(new int[] {i, j}, 1, visit, table, puzzlePieces);
            }
        }
        
        int idx = 0;
        boolean[] used = new boolean[puzzlePieces.size()];
        
        for(Piece b : boardPieces){
            idx = 0;
            for(Piece p : puzzlePieces){
                if(used[idx++]) continue;
                int cnt = comparePieces(b, p);
                if(cnt == 0) continue;
                System.out.println("b : \n" + b);
                System.out.println("p : \n" + p);
                System.out.println("count : " + cnt);
                
                answer += cnt;
                used[idx - 1] = true;
                break;
            }
        }        
        
        return answer;
    }
    
    public int comparePieces(Piece b, Piece p){
        for(int i = 0; i < 4; i++){
            int br = b.arr.length, bc = b.arr[0].length;
            int pr = p.arr.length, pc = p.arr[0].length;
            if(br != pr && br != pc && bc != pc && bc != pr) return 0;
            if(br == pr && bc == pc) {
                int cnt = countCells(b, p);
                if(cnt > 0) return cnt;
            }
            p.rotate();
        }
        return 0;
    }
    
    public int countCells(Piece b, Piece p){
        int r = b.arr.length, c = b.arr[0].length;
        int cnt = 0;
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(b.arr[i][j] == p.arr[i][j]) 
                    cnt += p.arr[i][j];
                else return 0;
            }
        }
        
        return cnt;
    }
    
    public void splitPieces(int[] pos, int target, boolean[][] visit, int[][] board, List<Piece> pieces){
        Queue<int[]> q = new LinkedList<>();
        visit[pos[0]][pos[1]] = true;
        q.add(pos);
        
        int rowMin = pos[0], rowMax = pos[0], colMin = pos[1], colMax = pos[1]; 
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int d = 0; d < 4; d++){
                int nx = cur[0] + dx[d], ny = cur[1] + dy[d];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visit[nx][ny] || board[nx][ny] != target) continue;
                q.add(new int[] {nx, ny});
                visit[nx][ny] = true;
                
                if(nx < rowMin) rowMin = nx;
                if(nx > rowMax) rowMax = nx;
                if(ny < colMin) colMin = ny;
                if(ny > colMax) colMax = ny;
            }
        }
      
        int r = rowMax - rowMin + 1, c = colMax - colMin + 1;
        int[][] tmp = new int[r][c];
        
        for(int i = 0; i < r; i++)
           for(int j = 0; j < c; j++)
                if(board[rowMin + i][colMin + j] == target) tmp[i][j] = 1;
        
        pieces.add(new Piece(tmp));
    }
}



class Piece {
    public int[][] arr;
    public Piece(int[][] arr){
        int r = arr.length, c = arr[0].length; 
        this.arr = new int[r][c];

        for(int i = 0; i < r; i++)
            this.arr[i] = arr[i].clone();
    }
    
    public void rotate(){
        int r = this.arr.length, c = this.arr[0].length;
        int[][] tmp = new int[c][r];
        
        for(int i = 0; i < r; i++){
            for(int j =0; j < c; j++) {
                tmp[j][i] = arr[r-i-1][j];
            }
        }
        
        this.arr = tmp;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        
        for(int i =0 ; i< arr.length;i ++){
            for(int j =0;j < arr[0].length;j ++){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        
        sb.append("\n");
        
        return sb.toString();
    }
}


