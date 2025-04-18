import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] record) {
        int len = record.length;
        
        Map<String, String> m = new HashMap<>();
        List<Pair> list = new ArrayList<>();
        
        StringTokenizer st; 
        int idx = 0, cnt = 0, status = 0;
        String statusString, id, name;
        
        for(String s : record) {
            st = new StringTokenizer(s, " ");
           
            statusString = st.nextToken();
            id = st.nextToken();
            
            if(statusString.equals("Enter")) {
                name = st.nextToken();
                m.put(id, name);
                status = 1; cnt++;
            } else if(statusString.equals("Leave")){
                status = -1;
                cnt++;
            } else if(statusString.equals("Change")) {
                name = st.nextToken();
                m.put(id, name);
                status = 0;
            }
            
            list.add(new Pair(status, id));
        }
        
        String[] answer = new String[cnt];
        
        String enter = "님이 들어왔습니다.";
        String leave = "님이 나갔습니다.";
        
        for(int i = 0; i < len; i++) {
            Pair p = list.get(i);
            if(p.status == 0) continue;
            String cur = m.get(p.id);
            if(p.status == 1) cur += enter;
            else if(p.status == -1) cur += leave;
            answer[idx++] = cur;
        }
        
        return answer;
    }
    
    public static class Pair {
        int status;
        String id;
        
        public Pair(int status, String id) {
            this.status = status;
            this.id = id;
        }
    }
}