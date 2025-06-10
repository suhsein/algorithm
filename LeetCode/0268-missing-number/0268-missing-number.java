class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0, all = 0;
        for(int x : nums)
            sum += x;
        
        for(int i = 0; i <= nums.length; i++)
            all += i;

        return all - sum;
    }
}