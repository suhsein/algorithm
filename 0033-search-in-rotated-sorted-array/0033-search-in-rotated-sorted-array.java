class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int lo = 0, hi = n - 1, mid;

        while(lo < hi) {
            mid = (lo + hi) / 2;

            if(nums[mid] > nums[hi])
                lo = mid + 1;
            else
                hi = mid;
        }

        int pivot = hi;
        
        int answer = binarySearch(nums, 0, pivot - 1, target);
        if(answer >= 0 && answer < n && nums[answer] == target)
            return answer;
        
        answer = binarySearch(nums, pivot, n - 1, target);
        if(answer >= 0 && answer < n && nums[answer] == target)
            return answer;

        return -1;
    }

    public int binarySearch(int[] nums, int lo, int hi, int target) {
        while(lo < hi){
            int mid = (lo + hi) / 2;

            if(nums[mid] == target)
                return mid;
            if(nums[mid] < target)
                lo = mid + 1;
            else 
                hi = mid;
        }

        return hi;
    }
}