class Solution {
    public boolean canJump(int[] nums) {
        int jump = 0;

        for(int x : nums){
            if(jump < 0)
                return false;
            if(x > jump)
                jump = x;
            jump--;
        }
        
        return true;
    }

}