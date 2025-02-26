import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(i > 0 && arr[i] == arr[i-1]) continue;
            answer.add(arr[i]);
        }
        
        return answer
            .stream()
            .mapToInt(i->i)
            .toArray();
    }
}