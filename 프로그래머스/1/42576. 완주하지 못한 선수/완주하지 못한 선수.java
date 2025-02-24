import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> m = new HashMap<>();
        
        for(String cur : participant){
            if(m.containsKey(cur)){
                m.put(cur, m.get(cur) + 1);
            } else m.put(cur, 1);
        }
        
        for(String cur : completion) m.put(cur, m.get(cur) - 1);
        
        for(String key : m.keySet()){
            if(m.get(key) == 1) return key;
        }
       
        return "";
    }
}