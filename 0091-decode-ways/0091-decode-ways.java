class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        if(s.charAt(0) == '0')
            return 0;
        if(n == 1)
            return 1;

        int[] dp = new int[n];

        dp[0] = 1;
        dp[1] = 1;
        if(s.charAt(0) >= '3' && s.charAt(1) == '0') 
            dp[1] = 0;
        if(s.charAt(0) == '1' && s.charAt(1) > '0'
            || s.charAt(0) == '2' && s.charAt(1) >= '1' && s.charAt(1) <= '6')
            dp[1] = 2;

        for(int i = 2; i < n; i++) {
            char cur = s.charAt(i), prev = s.charAt(i - 1);
            if(cur == '0') {
                if(prev == '0' || prev >= '3')
                    return 0;
                dp[i] = dp[i - 2];
                continue;
            } 
            dp[i] = dp[i - 1];
            if(prev == '1' 
            || prev == '2' && cur >= '0' && cur <= '6') 
                dp[i] = dp[i - 1] + dp[i - 2];
            else
                dp[i] = dp[i - 1];
        }

        return dp[n - 1];
    }
}