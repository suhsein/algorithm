import java.util.*;

class Solution {
    int answer = 0, N = 0;
    boolean[] v;
    
    public int solution(int n, int[][] computers) {
        v = new boolean[n];
        N = n;
        
        for(int i = 0; i < n; i++) if(!v[i]) bfs(i, computers);
        
        return answer;
    }
    
    public void bfs(int x, int[][] computers){
        answer++;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        v[x] = true;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = 0; i < N; i++) {
                if(cur == i || v[i] || computers[cur][i] != 1) continue;
                v[i] = true;
                q.add(i);
            } 
        }
    }
}