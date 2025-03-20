import java.util.*;
import java.io.*;


public class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int N = 0;
    static boolean[][] visit;
    static String[] map;
    static List<Integer> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N][N];
        map = new String[N];
        
        for(int i = 0; i < N; i++) 
            map[i] = br.readLine();

         for(int i = 0; i < map.length; i++){
             for(int j = 0; j < map[i].length(); j++){
                 if(map[i].charAt(j) == '1' && !visit[i][j]) {
                     bfs(i,j);
                 }
             }
         }
        
        Collections.sort(ans);
        System.out.println(ans.size());
        for(Integer a : ans) System.out.println(a);
    }
    
    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});
        visit[x][y] = true;
        int cnt = 0;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            cnt++;
            
            for(int d = 0; d < 4; d++){
                int nx = cur[0] + dx[d], ny = cur[1] + dy[d];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visit[nx][ny] || map[nx].charAt(ny) != '1') continue;
                visit[nx][ny] = true;
                q.add(new int[] {nx,ny});
            }
        }
        
        ans.add(cnt);
    }
}