import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> m = new HashMap<>();
        
        for(String cur : participant) m.put(cur, m.getOrDefault(cur, 0) + 1);
        for(String cur : completion) m.put(cur, m.get(cur) - 1);
        
        for(Map.Entry<String,Integer> entry : m.entrySet()){
            if(entry.getValue() == 1) return entry.getKey();
        }
       
        return "";
    }
}