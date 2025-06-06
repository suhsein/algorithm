class Solution {
    public int findMin(int[] nums) {
        int answer = nums[0];
        for(int x : nums){
            if(x < answer) 
                answer = x;
        }
        return answer;
    }
}