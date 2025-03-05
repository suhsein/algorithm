import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0, offset = 0;
        
        Arrays.sort(people);
        
        for(int i = people.length - 1; i >= offset; i--) {
            if(people[i] + people[offset] <= limit) offset++;
            answer++;
        }
        
        return answer;
    }
}