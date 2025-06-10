class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        int idx = binarySearch(nums, target, 0, pivot - 1);
        if(idx >= 0 && idx < pivot && nums[idx] == target) 
            return idx;
        idx = binarySearch(nums, target, pivot, nums.length - 1);
        if(idx >= 0 && idx < nums.length && nums[idx] == target) 
            return idx;

        return -1;
    }

    public int findPivot(int[] nums) {
        int lo = 0, hi = nums.length - 1, mid;

        while(lo < hi) {
            mid = (lo + hi) / 2;

            if(nums[mid] > nums[hi])
                lo = mid + 1;
            else
                hi = mid;
        }

        return hi;
    }

    public int binarySearch(int[] nums, int target, int lo, int hi) {
        int mid;

        while(lo < hi) {
            mid = (lo + hi) / 2;

            if(nums[mid] == target)
                return mid;
            if(nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }

        return hi;
    }
}