class Solution {
    public int missingNumber(int[] nums) {
        int max = 0;

        for(int x : nums)
            if(x > max)
                max = x;
        
        boolean[] visit = new boolean[max + 1];

        for(int x : nums)
            visit[x] = true;

        for(int i = 0; i <= max; i++)
            if(!visit[i])
                return i;
        
        return max + 1;
    }
}