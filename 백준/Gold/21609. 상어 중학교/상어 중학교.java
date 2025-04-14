import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int N, M, ans = 0, mx = 0;
    static boolean[][] v;
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static Block[] standard;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        v = new boolean[N][N];
        standard = new Block[M + 1];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            init();

            for(int i = 0; i< N; i++){
                for(int j = 0; j < N; j++){
                    if(!v[i][j] && map[i][j] > 0) bfs(i,j);
                }
            }
        
            selectMax();
            if(mx == 0) break;
            int score = standard[mx].cnt * standard[mx].cnt;
            ans += score;

            clean(standard[mx].x, standard[mx].y);
            gravity();
            rotate();
            gravity();
        }

        br.close();
        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
    }

    public static void rotate(){
        int[][] tmp = new int[N][N];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                tmp[N - j - 1][i] = map[i][j];
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                map[i][j] = tmp[i][j];
            }
        }
    }

    public static void init(){
        for(int i = 0; i < N; i++) Arrays.fill(v[i], false);
        for(int i = 0; i <= M; i++) standard[i] = new Block(N, N, 0, 0);
        mx = 0;
    }

    public static void selectMax(){
        for(int i = 1;  i <= M; i++) {
            if(standard[i].cnt > standard[mx].cnt) mx = i;
            else if(standard[i].cnt == standard[mx].cnt) {
                if(standard[i].rainbow > standard[mx].rainbow) mx = i;
                else if(standard[i].rainbow == standard[mx].rainbow) {
                    if(standard[i].x > standard[mx].x) mx = i;
                    else if(standard[i].x == standard[mx].x && standard[i].y > standard[mx].y) 
                         mx = i;
                }
            }
        }
    }

    public static void gravity() {
       for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[j][i] < 0) continue;
                int idx = j + 1;
                while(idx < N && map[idx][i] < -1) idx++;
                if(idx == j + 1) continue;
                int offset = idx - 1 - j;
                for(int k = idx - 1; k >= offset; k--) {
                    if(map[k - offset][i] < 0) break;
                    map[k][i] = map[k - offset][i];
                    map[k - offset][i] = -2;
                }
            }
        }
    }
    public static void clean(int x, int y){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));

        int num = map[x][y], cnt = 1;
        map[x][y] = -2;
        
        boolean[][] visit = new boolean[N][N];
        visit[x][y] = true;
        
        while(!q.isEmpty()){
            Pair cur = q.poll();
            map[cur.x][cur.y] = -2;
            
            for(int d = 0; d < 4; d++){
                int nx = cur.x + dx[d], ny = cur.y + dy[d];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visit[nx][ny] || map[nx][ny] == -1 || map[nx][ny] != 0 && map[nx][ny] != num) continue;
                visit[nx][ny] = true; cnt++;
                q.add(new Pair(nx, ny));
            }
        }
    }

    public static void bfs(int x, int y){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));

        int num = map[x][y], cnt = 1, rainbow = 0;
        
        boolean[][] visit = new boolean[N][N];
        visit[x][y] = true;
        
        while(!q.isEmpty()){
            Pair cur = q.poll();
            
            for(int d = 0; d < 4; d++){
                int nx = cur.x + dx[d], ny = cur.y + dy[d];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visit[nx][ny] || map[nx][ny] == -1 || map[nx][ny] != 0 && map[nx][ny] != num) continue;
                if(map[nx][ny] == num) v[nx][ny] = true;
                if(map[nx][ny] == 0) rainbow++;
                visit[nx][ny] = true; cnt++;
                q.add(new Pair(nx, ny));
            }
        }

        if(cnt >= 2 && 
           (cnt > standard[num].cnt || cnt == standard[num].cnt && rainbow > standard[num].rainbow
           || cnt == standard[num].cnt && rainbow == standard[num].rainbow && x > standard[num].x
           || cnt == standard[num].cnt && rainbow == standard[num].rainbow && x == standard[num].x && y > standard[num].y)) {
            standard[num].update(x, y, rainbow, cnt);
        }
    }

    public static class Block {
        int x; 
        int y;
        int rainbow;
        int cnt;

        public Block(int x, int y, int rainbow, int cnt){
            this.x = x;
            this.y = y;
            this.rainbow = rainbow;
            this.cnt = cnt;
        }

        public void update(int x, int y, int rainbow, int cnt) {
            this.x = x;
            this.y = y;
            this.rainbow = rainbow;
            this.cnt = cnt;
        }
    }

    public static class Pair {
        int x;
        int y;
        
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}