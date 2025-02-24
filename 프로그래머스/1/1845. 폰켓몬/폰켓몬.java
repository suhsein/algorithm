import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int x : nums) s.add(x);
        
        return Math.min(s.size(), nums.length/2);
    }
}