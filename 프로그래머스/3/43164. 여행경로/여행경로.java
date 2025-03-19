import java.util.*;

class Solution {
    List<String> list = new ArrayList<>();
    boolean[] v;
    boolean found = false;
    int n = 0;
    
    public String[] solution(String[][] tickets) {
        n = tickets.length;
        v = new boolean[n];
        
        Arrays.sort(tickets, (o1, o2) -> {
            if(o1[0].toString().equals(o2[0]))
                return o1[1].toString().compareTo(o2[1].toString());
            
            return o1[0].toString().compareTo(o2[0].toString());
        });
            
        dfs(0, "ICN", tickets);
        
        return list.toArray(new String[list.size()]);
    }
    
    public void dfs(int cnt, String cur, String[][] tickets){
        list.add(cur);
        
        if(cnt == n) {
            found = true;
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(v[i] || !tickets[i][0].equals(cur)) continue;
            v[i] = true;
            dfs(cnt + 1, tickets[i][1], tickets); 
            if(found) return;
            v[i] = false;
            list.remove(list.size() - 1);
        }
    }
}