import java.util.*;

class Solution {
    Map<String, List<String>> m = new HashMap<>();
    Map<String, Boolean> v = new HashMap<>();
    
    int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {   
        int n = words[0].length();
        
        adj(begin, words);
        dfs(target, begin, 0);
        
        return (answer == Integer.MAX_VALUE) ? 0 : answer;
    }
    
    public void dfs(String target, String cur, int cnt) {
        if(cur.equals(target)) {
            if(cnt < answer) answer = cnt;
            return;
        }
        
        List<String> nxtList = m.get(cur);
        if(nxtList == null) return;
        
        for(String nxt : nxtList){
            boolean visit = v.get(nxt);
            if(visit) continue;
            v.put(nxt, true);
            dfs(target, nxt, cnt + 1);
            v.put(nxt, false);
        }
    }
    
    public void adj(String begin, String[] words){
        int n = words[0].length();
        
        List<String> tmp = new ArrayList<>(Arrays.asList(words));
        tmp.add(begin);
        
        for(String w : tmp) {
            m.put(w, new ArrayList<>());
            v.put(w, false);
            
            for(String b : words) {
                if(w.equals(b)) continue;
                int cnt = 0;
                
                for(int i = 0; i < n; i++) 
                    if(w.charAt(i) == b.charAt(i)) cnt++;
                if(cnt == n - 1) m.get(w).add(b);
            }
        }
    }
}