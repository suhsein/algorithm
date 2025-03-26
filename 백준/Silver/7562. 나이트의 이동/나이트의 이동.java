import java.util.*;
import java.io.*;

public class Main{
    static int[] dx = { -2, -2, -1, -1, 1, 1, 2, 2 };
    static int[] dy = { -1, 1, -2, 2, -2, 2, -1, 1 };
    static int[][] arr;
    static int[][] pos;
    static int N, ans;
    static final int INF = Integer.MAX_VALUE;
    static BufferedWriter bw;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        pos = new int[2][2];
       
        while(T-- > 0){
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            for(int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < 2; j++)
                    pos[i][j] = Integer.parseInt(st.nextToken());
            }
            bfs();
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void bfs() throws IOException {
        if(pos[0][0] == pos[1][0] &&  pos[0][1] == pos[1][1]) {
            bw.write("0\n");
            return;
        }
        
        
        for(int i =  0; i < N; i++) Arrays.fill(arr[i], INF);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {pos[0][0], pos[0][1]});

        ans = 0;
        arr[pos[0][0]][pos[0][1]] = 0;
        int nx, ny; 
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int d = 0; d < 8; d++) {
                nx = cur[0] + dx[d]; ny = cur[1] + dy[d];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(arr[nx][ny] != INF) continue;
                
                arr[nx][ny] = arr[cur[0]][cur[1]] + 1;
                if(arr[nx][ny] > ans) ans = arr[nx][ny];
                
                if(nx == pos[1][0] && ny == pos[1][1]) {
                    bw.write(Integer.toString(ans) + "\n");
                    return;
                }
                
                q.add(new int[] {nx, ny});
            }            
        }
    }
}