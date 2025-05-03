import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int len = money.length;
        int MOD = 1000000007;
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for(int i = 0; i < len; i++) {
            for(int j = money[i]; j <= n; j++){
                dp[j] += dp[j - money[i]] % MOD;
            }
        }
        
        return dp[n];
    }
}