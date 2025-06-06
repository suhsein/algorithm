class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] answer = new int[n];
        prefix[0] = suffix[n - 1] = 1;
       
        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
            suffix[n - i - 1] = suffix[n - i] * nums[n - i];
        }
        
        for(int i = 0; i < n; i++)
            answer[i] = prefix[i] * suffix[i];
        
        return answer;
    }
}