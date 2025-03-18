import java.util.*;


class Solution {
    public static int mod = 1000000007;
    public static int mx = 100;
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[mx][mx];
        dp[0][0] = 1;
        
        for(int[] p : puddles){
            dp[p[0] - 1][p[1] - 1] = -1;
        }
       
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                if(dp[i][j] == -1) continue;
                if(i > 0 && dp[i - 1][j] != -1) dp[i][j] += (dp[i - 1][j] % mod);
                if(j > 0 && dp[i][j - 1] != -1) dp[i][j] += (dp[i][j - 1] % mod);
            }
        }
    
        return dp[m - 1][n - 1] % mod; 
    }
}
