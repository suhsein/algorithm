import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main {
    static int[][] dp = new int[2][100005];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int ans, n;
        StringTokenizer st;
        
        while(t-- > 0) {
            n = Integer.parseInt(br.readLine());

            for(int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < n; j++)
                    dp[i][j] = Integer.parseInt(st.nextToken());
            }

            dp[0][1] += dp[1][0];
            dp[1][1] += dp[0][0];
            
            for(int i = 2; i < n; i++){
                dp[0][i] += Math.max(dp[1][i - 1], dp[1][i - 2]);
                dp[1][i] += Math.max(dp[0][i - 1], dp[0][i - 2]);
            }
            
            bw.write(Integer.toString(Math.max(dp[0][n - 1], dp[1][n - 1])) + "\n");
        }
       
        br.close();
        bw.flush();
        bw.close();
    }
    
   
}