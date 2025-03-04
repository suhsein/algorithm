import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = { 0, 0 };
        TreeMap<Integer, Integer> m = new TreeMap<>();
        
        for(String cur : operations){
            String[] tmp = cur.split(" ");
            if(tmp[0].equals("I")) {
                Integer x = Integer.parseInt(tmp[1]);
                m.put(x, m.getOrDefault(x, 0) + 1);
            } else {
                Map.Entry<Integer, Integer> e = null;
                
                if(m.isEmpty()) continue;
                if(tmp[1].equals("1")) e = m.lastEntry();
                else e = m.firstEntry();
                    
                if (e.getValue() == 1) m.remove(e.getKey());  
                else m.put(e.getKey(), m.get(e.getKey()) - 1);
            }
        }
        
        if(!m.isEmpty()) {
            answer[0] = m.lastEntry().getKey();
            answer[1] = m.firstEntry().getKey();
        }
        
        return answer;
    }
}