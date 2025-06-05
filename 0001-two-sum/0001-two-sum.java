class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int x = target - nums[i];
            
            if(map.containsKey(x)) 
                return new int[] { i, map.get(x) };
            
            map.put(nums[i], i);
        }

        return new int[2];
    }
}