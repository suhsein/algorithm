import java.util.*;
import java.io.*;

public class Main {
    static List<List<Pair>> edges;
    static int INF = Integer.MAX_VALUE;
    static int[] dist;
    static boolean[] visit;
    static int N, s, e;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int u,v,w;
        
        edges = new ArrayList<>(N + 1);
        for(int i = 0; i <= N; i++) edges.add(new ArrayList<>());
        
        while(M-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            edges.get(u).add(new Pair(v, w));
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
      
        Dijkstra();
        System.out.println(dist[e]);
    }
    
    public static void Dijkstra(){
        dist = new int[N + 1]; 
        visit = new boolean[N + 1];
        Arrays.fill(dist, INF);
        dist[s] = 0;
        
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(s, 0));
        
        while(!q.isEmpty()){
            Pair cur = q.poll();
            
            if(visit[cur.v]) continue;
            visit[cur.v] = true;
            
            for(Pair nxt : edges.get(cur.v)){
                if(visit[nxt.v]) continue;
                int tmp = dist[cur.v] + nxt.w;
                if(tmp < dist[nxt.v]) {
                    dist[nxt.v] = tmp;
                    q.add(new Pair(nxt.v, dist[nxt.v]));
                }
            }
        }
        
    }
    
    public static class Pair implements Comparable<Pair>{
        int v; 
        int w;
        public Pair(int v, int w){
            this.v = v;
            this.w = w;
        }
        public int compareTo(Pair p){
            return this.w - p.w;
        }
    }
}
