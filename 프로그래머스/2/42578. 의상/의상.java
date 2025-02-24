import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> m = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++) 
            m.put(clothes[i][1], m.getOrDefault(clothes[i][1], 0) + 1);
        
        
        for(Map.Entry<String, Integer> e : m.entrySet()){
            answer *= (e.getValue() + 1);
        }
        
        return answer - 1;
    }
}