import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0, mx = 0;
        int[] dist = new int [n + 1];
        
        Map<Integer, List<Integer>> m = new HashMap<>();
        for(int i = 1; i <= n; i++) m.put(i, new ArrayList<>());
        for(int[] e : edge) {
            m.get(e[0]).add(e[1]);
            m.get(e[1]).add(e[0]);
        }
            
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        
        while(!q.isEmpty()){
            int x = q.poll();
            
            for(int nxt : m.get(x)) {
                if (dist[nxt] != Integer.MAX_VALUE) continue;
                dist[nxt] = dist[x] + 1;
                q.add(nxt);
                if(dist[nxt] > mx) mx = dist[nxt];
            }
        }
        
        for(int d : dist) if(d == mx) answer++;
        
        return answer;
    }
}