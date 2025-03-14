import java.util.*;


class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[501][501];
        int n = triangle.length;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i + 1; j++) {
                dp[i][j] = triangle[i][j];
                if(i != 0){
                    if(j == 0) dp[i][j] += dp[i - 1][j];
                    else dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }
        
        int mx = dp[n - 1][0];
        for(int i = 1; i < n; i++) if(dp[n - 1][i] > mx) mx = dp[n - 1][i];
        
        return mx;
    }
}