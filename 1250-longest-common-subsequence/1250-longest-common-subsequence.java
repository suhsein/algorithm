class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), answer = 0;
        int[] dp = new int[n];

        for(char c : text2.toCharArray()){
            int curLength = 0;

            for(int i = 0; i < n; i++) {
                if(curLength < dp[i])
                    curLength = dp[i];
                else if(c == text1.charAt(i)) {
                    dp[i] = curLength + 1;
                    if(dp[i] > answer) answer = dp[i];
                }
            }
        }

        return answer;
    }
}