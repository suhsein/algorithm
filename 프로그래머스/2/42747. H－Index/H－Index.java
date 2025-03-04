import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Integer[] c = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        
        Arrays.sort(c, Comparator.reverseOrder());
        
        for(int i = 0; i < c.length; i++)
            answer = Math.max(answer, Math.min(c[i], i + 1));
        
        return answer;
    }
}