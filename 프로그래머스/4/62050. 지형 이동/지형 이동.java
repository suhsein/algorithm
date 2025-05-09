import java.util.*;

class Solution {
    static int[][] visit;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int g = 1, N, answer = 0, cnt = 0;
    static int[] parent;
    static int[] rank;
    
    public int solution(int[][] land, int height) {
        N = land.length;
        visit = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++){
                if(visit[i][j] > 0) continue;
                bfs(land, i, j, height);
            }
        }
        
        List<Edge> edges = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int d = 0; d < 4; d++) {
                    int nx = i + dx[d], ny = j + dy[d];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if(visit[i][j] == visit[nx][ny]) continue;
                    
                    edges.add(new Edge(visit[i][j], visit[nx][ny],
                                    Math.abs(land[i][j] - land[nx][ny])));
                }
            }
        }
        
        Collections.sort(edges);
        
        parent = new int[g];
        rank = new int[g];
        
        for(int i = 1; i < g; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(Edge e : edges){
            union(e);
            if(cnt == g - 1) break;
        }
        
        return answer;
    }
    
    public void union(Edge e) {
        int u = find(e.u);
        int v = find(e.v);
    
        if(u == v) return;
        if(rank[u] < rank[v]) {
            int tmp = u;
            u = v;
            v = tmp;
        }
        
        parent[v] = u;
        if(rank[u] == rank[v]) rank[u]++;
        
        answer += e.w; cnt++;
    }
    
    public int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    
    public void bfs(int[][] land, int x, int y, int height) {
        Queue<Pair> q = new LinkedList<>();
        visit[x][y] = g;
        q.add(new Pair(x, y));
        
        while(!q.isEmpty()){
            Pair cur = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i], ny = cur.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visit[nx][ny] > 0) continue;
                int diff = Math.abs(land[cur.x][cur.y] - land[nx][ny]);
                if(diff > height) continue;
                visit[nx][ny] = g;
                q.add(new Pair(nx, ny));
            }
        }
        
        g++;
    }
    
    class Edge implements Comparable<Edge> {
        int u, v, w;
        
        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        
        public int compareTo(Edge e){ 
            return this.w - e.w;
        }
    }
    
    class Pair {
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}