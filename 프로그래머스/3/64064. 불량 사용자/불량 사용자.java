import java.util.*;

class Solution {
    static Set<String> result;
    static int N, M;
    static boolean[] visited;
    
    public int solution(String[] user_id, String[] banned_id) {
        N = user_id.length;
        M = banned_id.length;
        
        visited = new boolean[N];
        result = new HashSet<>();
        
        List<Integer> list = new ArrayList<>();
        dfs(list, user_id, banned_id);
        
        return result.size();
    }
    
    public void dfs(List<Integer> list, String[] user_id, String[] banned_id) {
        if(list.size() == M) {
            List<Integer> sorted = new ArrayList<>(list);
            Collections.sort(sorted);
            StringBuilder sb = new StringBuilder();
            for(int x : sorted) sb.append(x);
            result.add(sb.toString());
            return;
        } 
        
        for(int i = 0; i < N; i++) {
            if(visited[i] || !equals(user_id[i], banned_id[list.size()]))
                continue;
            visited[i] = true;
            list.add(i);
            dfs(list, user_id, banned_id);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
    
    public boolean equals(String user, String banned) {
        if(user.length() != banned.length()) return false;
        for(int i = 0; i < user.length(); i++) {
            if(banned.charAt(i) == '*') continue;
            if(user.charAt(i) != banned.charAt(i)) return false;
        }
        return true;
    }
}