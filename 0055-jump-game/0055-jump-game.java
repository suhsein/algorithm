class Solution {
    static boolean[] dp;
    static int n;

    public boolean canJump(int[] nums) {
        n = nums.length;
        dp = new boolean[n];

        dfs(0, nums);

        return dp[n - 1];
    }

    public void dfs(int curIdx, int[] nums) {
        dp[curIdx] = true;

        if(curIdx == n - 1)
            return;

        for(int i = 1; i <= nums[curIdx]; i++) {
            if(!dp[curIdx + i])
                dfs(curIdx + i, nums);
            if(dp[n - 1]) return;
        }
    }
}