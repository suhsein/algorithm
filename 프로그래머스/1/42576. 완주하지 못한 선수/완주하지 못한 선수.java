import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> pMap = new HashMap<>();
        for(String p : participant) pMap.put(p, pMap.getOrDefault(p, 0) + 1);
        for(String c : completion) pMap.put(c, pMap.get(c) - 1);
        
        for(Map.Entry<String, Integer> e : pMap.entrySet()) {
            if(e.getValue() == 1) {
                answer = e.getKey();
                break;
            }
        } 
        
        return answer;
    }
}