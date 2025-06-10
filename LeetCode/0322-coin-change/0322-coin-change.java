class Solution {
    public int coinChange(int[] coins, int amount) {
        int MAX = amount + 1;
        int[] dp = new int[MAX];
        Arrays.fill(dp, MAX);
        dp[0] = 0;

        for(int i = 0; i < coins.length; i++) 
            for(int j = coins[i]; j <= amount; j++) 
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);

        return dp[amount] == MAX ? -1 : dp[amount];
    }
}