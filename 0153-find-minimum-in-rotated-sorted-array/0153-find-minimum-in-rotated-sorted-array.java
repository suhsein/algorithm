class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        int mid;

        while(lo < hi) {
            mid = (lo + hi) / 2;
            if(nums[mid] > nums[hi])
                lo = mid + 1;
            else
                hi = mid;
        }

        return nums[hi % nums.length];
    }
}