import java.util.*;
import java.io.*;


public class Main {
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> list;
    static int N, M;
    static int[] idg;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        list = new ArrayList<>(N + 1);
        idg = new int[N + 1];
        int a, b;
       
        for(int i = 0; i <= N; i++) 
            list.add(new ArrayList<Integer>());
        
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            idg[b]++;
            list.get(a).add(b);
        }
        
        br.close();
        
        topologySort();
        System.out.println(sb.toString());
    }
    
    public static void topologySort(){
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++)
            if(idg[i] == 0) q.add(i);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur);
            sb.append(" ");
          
            for(int x : list.get(cur)){
                idg[x]--; 
                if(idg[x] == 0) q.add(x);
            }
        }
    }
}