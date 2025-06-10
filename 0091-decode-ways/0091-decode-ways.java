class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        if(s.charAt(0) == '0')
            return 0;
        if(n == 1)
            return 1;

        int[] dp = new int[n];
        dp[0] = 1;

        for(int i = 1; i < n; i++) {
            char cur = s.charAt(i), prev = s.charAt(i - 1);
            if(cur == '0') {
                if(prev == '0' || prev >= '3')
                    return 0;
                dp[i] = (i < 2) ? 1 : dp[i - 2];
                continue;
            } 
            if(prev == '1' 
            || prev == '2' && cur >= '0' && cur <= '6') 
                dp[i] = (i < 2) ? 2 : dp[i - 1] + dp[i - 2];
            else
                dp[i] = dp[i - 1];
        }

        return dp[n - 1];
    }
}