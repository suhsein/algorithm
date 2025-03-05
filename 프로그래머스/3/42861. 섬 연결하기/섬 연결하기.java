import java.util.*;

class Solution {
    int answer = 0, cnt = 0;
    int[] p = null;
    int[] rk = null;
    
    public int solution(int n, int[][] costs) {
        p = new int[n];
        rk = new int[n];
    
        for(int i = 0; i < n; i++) {
            p[i] = i;
            rk[i] = 1;
        }
        
        List<Edge> edges = new ArrayList<>();
        
        for(int i = 0; i < costs.length; i++)
            edges.add(new Edge(costs[i][2], costs[i][0], costs[i][1]));
        
        Collections.sort(edges);
        
        for(Edge e : edges){
            union(e);
            if(cnt == n - 1) break;
        }
        
        return answer;
    }
    
    int find(int x){
        if(p[x] == x) return x;
        return p[x] = find(p[x]);
    }
    
    void union(Edge e){
        int up = find(e.u);
        int vp = find(e.v);
        
        if(up == vp) return;
        
        if(rk[up] < rk[vp]) {
            int tmp = up;
            up = vp;
            vp = tmp;
        }
        
        p[vp] = up;
        
        if(rk[up] == rk[vp]) rk[up]++;
        
        answer += e.w;
        cnt++;
    }
}

class Edge implements Comparable<Edge> {
    public int w;
    public int u;
    public int v;
    
    public Edge(int w, int u, int v){
        this.w = w;
        this.u = u;
        this.v = v;
    }
    
    public int compareTo(Edge e) {
        return this.w - e.w;
    }
}