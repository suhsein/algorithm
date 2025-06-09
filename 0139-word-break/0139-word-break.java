class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        int max = 0;
        for(String w : wordDict)
            if(w.length() > max) 
                max = w.length();

        dp[0] = true; // empty string ""

        for(int i = 1; i <= n; i++) {
            for(int j = i - 1; j >= Math.max(0, i - max); j--) {
                if(dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}