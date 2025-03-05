import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0, len = name.length(), move = len - 1;
       
        
        for(int i = 0; i < len; i++) {
            answer += Math.min(name.charAt(i) - 'A', Math.abs(name.charAt(i) - 'Z') + 1);
            
            if(i + 1 < len && name.charAt(i + 1) == 'A'){
                int endA = i + 1;
                while(endA < len && name.charAt(endA) == 'A') endA++;
                move = Math.min(move, Math.min(i * 2 + (len - endA), i + (len - endA) * 2));
            }
            
        }
       
        
        return answer + move;
    }
}