class Solution {
    static boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        dp = new boolean[n + 1];
        dp[0] = true;

        Set<String> set = new HashSet<>(wordDict);
        findWord(s, set, 0, n);

        return dp[n];
    }

    public void findWord(String s, Set<String> set, int start, int n) { 
        for(int i = start + 1; i <= n; i++){
            if(dp[i]) continue;
            if(set.contains(s.substring(start, i))) {
                dp[i] = true;
                if(dp[n]) return;
                findWord(s, set, i, n);
            }
        }
    }
}