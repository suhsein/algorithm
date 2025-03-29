import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static boolean[] visit;
    static int N, M, H, C;
    static List<Pair> home = new ArrayList<>();
    static List<Pair> chicken = new ArrayList<>();
    static int ans = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int x;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                x = Integer.parseInt(st.nextToken());
                if(x == 1) home.add(new Pair(i, j));
                if(x == 2) chicken.add(new Pair(i, j));
            }
        }

        H = home.size();
        C = chicken.size();
        
        visit = new boolean[C];
        bt(0, 0);
        
        bw.write(Integer.toString(ans));
        bw.flush();
        br.close();
        bw.close();
    }
    public static void calc(){
        int chickenDist = 0;
        int[] minDist = new int[H];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        
        for(int i = 0; i < C; i++){
            if(visit[i]) continue;

            for(int j = 0; j < H; j++){
                int curDist = chicken.get(i).getChickenDist(home.get(j));
                if(minDist[j] > curDist) minDist[j] = curDist;
            }
        }

        for(int i = 0; i < H; i++) chickenDist += minDist[i];
        if(ans > chickenDist) ans = chickenDist;
    }
    
    public static void bt(int offset, int cnt) {
        if(cnt == C - M) {
            calc();
            return;
        }

        for(int i = offset; i < C; i++){
            if(visit[i]) continue; 
            visit[i] = true;
            bt(i + 1, cnt +  1);
            visit[i] = false;
        }
    }

    public static class Pair {
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int getChickenDist(Pair p){
            return Math.abs(this.x - p.x) + Math.abs(this.y - p.y);
        }
    }
}