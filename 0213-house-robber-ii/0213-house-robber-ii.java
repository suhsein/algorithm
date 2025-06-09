class Solution {
   public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        
        if(n == 1)
            return nums[0];
        if(n == 2)
            return Math.max(nums[0], nums[1]);
        if(n == 3)
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);

        dp[0][1] = dp[1][1] = nums[0];  // 1번 집을 터는 경우
        dp[1][0] = nums[1]; // 1번 집을 털지 않는 경우

        for(int i = 2; i < n - 1; i++){
            dp[i][0] = Math.max(dp[i - 2][0] + nums[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 2][1] + nums[i], dp[i - 1][1]);
        }

        return Math.max(Math.max(dp[n - 3][0] + nums[n - 1], dp[n - 2][1]), dp[n - 2][0]);
    }
}