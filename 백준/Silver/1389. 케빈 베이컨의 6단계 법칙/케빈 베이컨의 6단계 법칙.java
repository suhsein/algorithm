import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N, M;
    static List<List<Integer>> friends = new ArrayList<>();
    final static int INF = Integer.MAX_VALUE;
    static int ans = INF, mn = INF;
    static int[] kb;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        init();
        solve();
        
        bw.write(Integer.toString(ans));
        bw.flush();
        br.close();
        bw.close();
    }
    
    public static void solve() {
        for(int i = 1; i <= N; i++) dijkstra(i);
        for(int i = 1; i <= N; i++) {
            if(kb[i] == mn) {
                ans = i;
                break;
            }
        }    
    }
    
    public static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int a, b;
        
        for(int i = 0; i <= N; i++) friends.add(new ArrayList<>());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            friends.get(a).add(b);
            friends.get(b).add(a);
        }

        kb = new int[N + 1];
    }

    public static void dijkstra(int x){
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        dist[0] = dist[x] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(x);

        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int nxt : friends.get(cur)){
                if(dist[nxt] != INF) continue;
                dist[nxt] = dist[cur] + 1;
                q.add(nxt);
            }
        }

        for(int i = 1; i <= N; i++) kb[x] += dist[i];
        if(kb[x] < mn) mn = kb[x];
    }
}