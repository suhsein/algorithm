import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int srx, sry, sbx, sby;
    static int ans = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        String str; 
        for(int i = 0; i < N; i++){
            str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'R') {
                    srx = i;
                    sry = j;
                }
                if(map[i][j] == 'B') {
                    sbx = i;
                    sby = j;
                }
            }
        } 

        bfs();
        if(ans == Integer.MAX_VALUE) ans = -1;
        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }

    public static void bfs(){
        Queue<Marble> q = new LinkedList<>();
        q.add(new Marble(srx, sry, sbx, sby, 1));
        boolean visit[][][][] = new boolean[N][M][N][M];
        visit[srx][sry][sbx][sby] = true;

        while(!q.isEmpty()){
            Marble m = q.poll();
            
            for(int d = 0; d < 4; d++) {    
                int rx = m.rx, ry = m.ry, bx = m.bx, by = m.by, nx, ny;
                boolean redHole = false, blueHole = false;
                
                while(true) {
                    nx = rx + dx[d]; ny = ry + dy[d];
                    if(map[nx][ny] == '#') break;
                    rx = nx; ry = ny;
                    if(map[nx][ny] == 'O') {
                        redHole = true;
                        break;
                    }
                }

                while(true){
                    nx = bx + dx[d]; ny = by + dy[d];
                    if(map[nx][ny] == '#') break;
                    bx = nx; by = ny;
                    if(map[nx][ny] == 'O') {
                        blueHole = true;
                        break;
                    }
                }
                
                if(blueHole) continue;
                if(redHole && !blueHole) {
                    ans = Math.min(ans, m.cnt);
                    return;
                }

                if(rx == bx && ry == by) {
                    if(d == 0) {
                        if(m.rx < m.bx) bx++;
                        else rx++;
                    } 
                    if(d == 1){
                        if(m.ry < m.by) ry--;
                        else by--;
                    }
                    if(d == 2) {
                        if(m.rx > m.bx) bx--;
                        else rx--;
                    }
                    if(d == 3) {
                        if(m.ry > m.by) ry++;
                        else by++;
                    }
                }
               
                if(!visit[rx][ry][bx][by]) {
                    visit[rx][ry][bx][by] = true;
                    if(m.cnt < 10) q.add(new Marble(rx, ry, bx, by, m.cnt + 1));
                }
            }
        }
    }

    public static class Marble {
        int rx;
        int ry;
        int bx;
        int by;
        int cnt;
        public Marble(int rx, int ry, int bx, int by, int cnt){
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
    }
}