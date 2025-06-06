class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxSoFar = nums[0], minSoFar = nums[0], answer = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int tmpMaxSoFar = Math
                .max(Math.max(maxSoFar * nums[i], minSoFar * nums[i]), nums[i]);
            minSoFar = Math.min(Math.min(maxSoFar * nums[i], minSoFar * nums[i]), nums[i]);

            maxSoFar = tmpMaxSoFar;
            answer = Math.max(answer, maxSoFar);
        }
        
        return answer;
    }
}