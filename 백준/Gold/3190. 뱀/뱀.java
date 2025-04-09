import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, K, L, ans = 1, curDir = 0;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0}; // CW
    static List<Pair> apples, dir;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        init();
        startGame();
       
        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }

    public static void startGame() {
        boolean[][] visit = new boolean[N + 1][N + 1];
        Deque<Pair> snake = new ArrayDeque<>();
        snake.addFirst(new Pair(1,1));
        visit[1][1] = true;
        
        while(!snake.isEmpty()){
            Pair cur = snake.peekFirst();

            int nx = cur.x + dx[curDir], ny = cur.y + dy[curDir];

            if(nx <= 0 || ny <= 0 || nx > N || ny > N) break;
            if(visit[nx][ny]) break;
            
            visit[nx][ny] = true;
            snake.addFirst(new Pair(nx, ny));

            boolean foundApple = findApple(nx, ny);

            if(!foundApple) {
                Pair tail = snake.pollLast();
                visit[tail.x][tail.y] = false;
            }
            
            changeDirection();

            ans++;
        }
    }

    public static boolean findApple(int nx, int ny){
        for(Pair p : apples){
            if(p.x == nx && p.y == ny) {
                 apples.remove(p);
                 return true;   
            }
        }
        return false;
    }

    public static void changeDirection(){
         for(Pair p : dir) {
            if(ans == p.x) {
                curDir = (p.y == 1) ? (curDir + 1) % 4 : (curDir - 1 + 4) % 4;
                break;
            }
        }
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        apples = new ArrayList<>();

        int x, y;
        
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            apples.add(new Pair(x, y));
        }

        L = Integer.parseInt(br.readLine());

        dir = new ArrayList<>();
        String tmp;
        
        for(int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            tmp = st.nextToken(); 
            y = (tmp.equals("L")) ? 0 : 1;
            dir.add(new Pair(x, y));
        }
    }

    public static class Pair{
        public int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}