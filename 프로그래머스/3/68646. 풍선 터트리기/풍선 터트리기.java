import java.util.*;
import java.lang.Math;

class Solution {
    public int solution(int[] a) {
        int n = a.length;
        
        if(n == 1) return 1;
        int answer = 0;
        
        int[][] dp = new int[n][2];
        
        dp[0][0] = a[0];
        dp[n - 1][1] = a[n - 1];
        
        for(int i = 1; i < n; i++) 
            dp[i][0] = Math.min(dp[i - 1][0], a[i]);            
        
        for(int i = n - 2; i >= 0; i--) 
            dp[i][1] = Math.min(dp[i + 1][1], a[i]);
        
        
        for(int i = 0; i < n; i++) {
            int leftMin = dp[i][0];
            int rightMin = dp[i][1];
            
            if(a[i] <= leftMin && a[i] >= rightMin
              || a[i] >= leftMin && a[i] <= rightMin) answer++;
        }
    
        return answer;
    }
   
}