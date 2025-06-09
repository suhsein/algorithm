class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, ans = 1;
        int[] dp = new int[n];

        for(int i = 0; i < n; i++) {
            dp[i] = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] <= nums[j]) continue;
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            if(dp[i] > ans) ans = dp[i];
        }

        return ans;
    }
}