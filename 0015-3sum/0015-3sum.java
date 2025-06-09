class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = n - 1;

            while(j < k) {
                if(j - 1 > i && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                if(k + 1 < n && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                
                int sum = nums[i] + nums[j] + nums[k];

                if(sum == 0) 
                    answer.add(Arrays.asList(nums[i], nums[j], nums[k]));

                if(sum < 0) 
                    j++;
                else 
                    k--;
            }
        }

        return answer;
    }
}