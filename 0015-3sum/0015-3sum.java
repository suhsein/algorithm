class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<Triplet> set = new HashSet<>();

        int n = nums.length;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int target = - (nums[i] + nums[j]);
                int idx = binarySearch(nums, j + 1, n, target);

                if(idx >= j + 1 && idx < n && nums[idx] == target) {
                    set.add(new Triplet(nums[i], nums[j], nums[idx]));
                }
            }
        }

        List<List<Integer>> answer = new ArrayList<>();

        for(Triplet t : set)
            answer.add(t.toList());

        return answer; 
    }

    public int binarySearch(int[] nums, int lo, int hi, int target) {
        int mid;

        while(lo < hi) {
            mid = (lo + hi) / 2;

            if(nums[mid] == target)
                return mid;
            if(nums[mid] < target)
                lo = mid + 1;
            if(nums[mid] > target)
                hi = mid - 1;
        }

        return hi;
    }

    public class Triplet {
        public int x, y, z;

        public Triplet(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int hashCode(){
            return Objects.hash(this.x, this.y, this.z);
        }

        public boolean equals(Object obj){
            if(!(obj instanceof Triplet))
                return false;
            Triplet t = (Triplet) obj;
            return (this.x == t.x && this.y == t.y && this.z == t.z);
        }

        public List<Integer> toList() {
            List<Integer> ret = new ArrayList<>();
            ret.add(x);
            ret.add(y);
            ret.add(z);

            return ret;
        }
    }
}