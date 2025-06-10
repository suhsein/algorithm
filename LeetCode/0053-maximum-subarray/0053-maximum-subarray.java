class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, answer, x;
        
        answer = x = nums[0];

        for(int i = 1; i < n; i++) {
            x = Math.max(x + nums[i], nums[i]);
            if(x > answer)
                answer = x;
        }

        return answer;
    }
}