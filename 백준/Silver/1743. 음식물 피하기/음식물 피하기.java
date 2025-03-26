import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    static int ans = 0, N, M, K;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
       
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];      
        visit = new boolean[N][M];
        
        int r, c;
        while(K-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            arr[r - 1][c - 1] = 1;
        }
        
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                if(!visit[i][j] && arr[i][j] == 1)
                    bfs(i, j);
       
        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void bfs(int x, int y) throws IOException {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visit[x][y] = true;
        int cnt = 1, nx, ny;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int d = 0; d < 4; d++){
                nx = cur[0] + dx[d];
                ny = cur[1] + dy[d];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visit[nx][ny] || arr[nx][ny] == 0) continue;
                visit[nx][ny] = true; q.add(new int[] {nx, ny});
                cnt++;                
            }
        }
        
        if(cnt > ans) ans = cnt;
    }
}