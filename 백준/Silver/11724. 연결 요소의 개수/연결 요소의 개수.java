import java.util.*;
import java.io.*;
import java.lang.Comparable;

public class Main {
    static BufferedWriter bw;
    static boolean[] visit;
    static List<List<Integer>> list;
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         bw = new BufferedWriter(new OutputStreamWriter(System.out));
         StringTokenizer st = new StringTokenizer(br.readLine(), " ");
         
         int N = Integer.parseInt(st.nextToken());
         int M = Integer.parseInt(st.nextToken());
         
         visit = new boolean[N + 1];
         list = new ArrayList<>(N + 1);
         for(int i = 0; i <= N; i++) list.add(new ArrayList<>());
             
         while(M-- > 0){
             st = new StringTokenizer(br.readLine(), " ");
             int u = Integer.parseInt(st.nextToken());
             int v = Integer.parseInt(st.nextToken());
             
             list.get(u).add(v);
             list.get(v).add(u);
         }     
         
         int ans = 0;
         for(int i = 1; i <= N; i++) {
             if(visit[i]) continue;
             bfs(i); ans++;
         }
         
         bw.write(Integer.toString(ans));
         br.close();
         bw.flush();
         bw.close();
    }
    
    public static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        visit[x] = true; q.add(x);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int nxt : list.get(cur)){
                if(visit[nxt]) continue;
                visit[nxt] = true; q.add(nxt);
            }
        }
    }
}