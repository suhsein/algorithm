import java.util.*;

class Solution {
    boolean[] visit = null;
    Map<Integer, List<Integer>> m = new HashMap<>();
   
    
    public int solution(int n, int[][] wires) {
        int answer = n, start = 0;
        visit = new boolean[n];
        
        for(int i = 0; i < wires.length; i++){
            m.put(wires[i][0], m.getOrDefault(wires[i][0], new ArrayList<>()));
            m.get(wires[i][0]).add(wires[i][1]);
            m.put(wires[i][1], m.getOrDefault(wires[i][1], new ArrayList<>()));
            m.get(wires[i][1]).add(wires[i][0]);
        }
     
        for(int i = 0; i < wires.length; i++) {
            Arrays.fill(visit, false);
            
            if(i == 0) start = wires[1][0];
            else start = wires[i - 1][0];
            
            m.get(wires[i][0]).remove(Integer.valueOf(wires[i][1]));
            m.get(wires[i][1]).remove(Integer.valueOf(wires[i][0]));
            
           
            bfs(start);
            int cnt = 0;
            for(int j = 0; j < n; j++) if(visit[j]) cnt++;
            
            answer = Math.min(answer, Math.abs(n - cnt - cnt));
            
            m.get(wires[i][0]).add(Integer.valueOf(wires[i][1]));
            m.get(wires[i][1]).add(Integer.valueOf(wires[i][0]));
        }
        
        return answer;
    }
    
    public void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start - 1] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            List<Integer> tmp = m.get(cur);

            for(Integer nxt : tmp) {
                if(visit[nxt - 1]) continue;
                visit[nxt - 1] = true;
                q.add(nxt);
            }
        }
    }
}
