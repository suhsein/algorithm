import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static BufferedReader br;
    static int[][] arr;
    static int[][] dp;
    static int ans = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
        System.out.println(ans);
    }
    
    public static void solve() {
        dp = new int[N + 1][M + 1];
        int tmp = 0;
        
        for(int i = 0; i <= N; i++) Arrays.fill(dp[i], Integer.MIN_VALUE);
        
        for(int i = 1; i <= N; i++) 
            for(int j = 1; j <= M; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i][j];
            
       
        for(int i = 1; i <= N; i++) 
             for(int j = 1; j <= M; j++)
                  calcPartialMax(i, j);
             
    }
    
    public static void calcPartialMax(int a, int b){
        for(int i = 1; i <= a; i++){
            for(int j = 1; j <= b; j++){
                int tmp = dp[a][b] - dp[i - 1][b] - dp[a][j - 1] + dp[i - 1][j - 1];
                if(tmp > ans) ans = tmp;
            }
        }
    }
    
    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
    }
}