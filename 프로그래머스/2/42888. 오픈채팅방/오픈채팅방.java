import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        int len = record.length;
        Map<String, String> m = new HashMap<>(); 
        int[] arr = new int[len]; // 1, -1
        String[] ord = new String[len];
        
        StringTokenizer st; 
        int idx = 0, cnt = 0;
        String status, id, name;
        for(String s : record) {
            st = new StringTokenizer(s, " ");
           
            status = st.nextToken();
            id = st.nextToken();
            
            if(status.equals("Enter")) {
                arr[idx] = 1;
                name = st.nextToken();
                m.put(id, name);
                ord[idx] = id;
                cnt++;
            } else if(status.equals("Leave")){
                arr[idx] = -1;
                ord[idx] = id;
                cnt++;
            } else if(status.equals("Change")) {
                arr[idx] = 0;
                name = st.nextToken();
                m.put(id, name);
            }
            idx++;
        }
        
        String[] answer = new String[cnt];
        
        idx = 0;
        for(int i = 0; i < len; i++) {
            if(arr[i] == 0) continue;
            String cur = m.get(ord[i]);
            cur += "님이 ";
            if(arr[i] == 1) cur += "들어왔습니다.";
            else if(arr[i] == -1) cur += "나갔습니다.";
            answer[idx++] = cur;
        }
        
        return answer;
    }
    
}