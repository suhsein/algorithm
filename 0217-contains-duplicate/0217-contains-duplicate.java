class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int x : nums) {
            if(!set.add(x))
                return true;
        }

        return false;
    }
}