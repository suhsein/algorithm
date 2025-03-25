import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw;
    static int[][] ans;
    static char[][] arr;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int N, M;
    static final int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         bw = new BufferedWriter(new OutputStreamWriter(System.out));
         StringTokenizer st = new StringTokenizer(br.readLine(), " ");
         
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         
         arr = new char[N][M];
         ans = new int[N][M];
         char[] chArr;
         
         for(int i = 0; i < N; i++) {
             Arrays.fill(ans[i], INF);
             chArr = (br.readLine()).toCharArray();       
             for(int j = 0; j < M; j++)
                 arr[i][j] = chArr[j];
         }
         
         bfs();
            
         bw.write(Integer.toString(ans[N - 1][M - 1]));
         br.close();
         bw.flush();
         bw.close();
    }
    
    public static void bfs(){
        Queue<Pair> q = new LinkedList<>();
        ans[0][0] = 1; q.add(new Pair(0, 0));
        int nx, ny;
        
        while(!q.isEmpty()){
            Pair cur = q.poll();
            for(int d = 0; d < 4; d++){
                nx = cur.x + dx[d];
                ny = cur.y + dy[d];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(ans[nx][ny] != INF || arr[nx][ny] == '0') continue;
                ans[nx][ny] = ans[cur.x][cur.y] + 1; 
                if(nx == N - 1 && ny == M - 1) return;
                q.add(new Pair(nx, ny));
            }   
        }
    }
    public static class Pair{
        int x, y;
        
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}