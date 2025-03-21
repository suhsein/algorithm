import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visit;
    static List<List<Integer>> edges;
    static int N, M, V;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
       
        visit = new boolean[N + 1];
        edges = new ArrayList<>(N + 1);
        
        for(int i = 0; i <= N; i++) edges.add(new ArrayList<>());
        
        int u, v;
        while(M-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            edges.get(u).add(v);
            edges.get(v).add(u);
        }
        
        for(int i = 1; i <= N; i++) Collections.sort(edges.get(i));
        
        sb = new StringBuilder();
        
        visit[V] = true;
        DFS(V);
        sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());
        BFS();
    }
    
    public static void DFS(int cur){
        sb.append(cur); sb.append(" ");
        
        for(int nxt : edges.get(cur)){
            if(visit[nxt]) continue;
            visit[nxt] = true; DFS(nxt);
        }
    }
    
    public static void BFS(){
        sb.setLength(0);
        Arrays.fill(visit, false);
        Queue<Integer> q = new LinkedList<>();
        visit[V] = true; q.add(V);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur); sb.append(" ");
            
            for(int nxt : edges.get(cur)){
                if(visit[nxt]) continue;
                visit[nxt] = true; q.add(nxt);
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
    