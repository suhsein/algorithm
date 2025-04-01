import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static boolean[] plug = new boolean[101];
    static int[] tools;
    static BufferedWriter bw;
    static int cnt = 0, ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        tools = new int[K];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < K ; i++) 
            tools[i] = Integer.parseInt(st.nextToken()); 

        List<Pair> list;
        
        for(int i = 0; i < K; i++){
            int cur = tools[i];
            if(plug[cur]) continue;
            if(cnt < N) {
                plug[cur] = true;
                cnt++;
                continue;
            }
            
            list = new ArrayList<>();
            
            for(int j = 1; j <= K; j++) {
                if(!plug[j]) continue;
                boolean flag = false;
                for(int k = i + 1; k < K; k++) {
                    if(tools[k] == j) {
                        list.add(new Pair(k, j));
                        flag = true;
                        break;
                    }
                }
                if(!flag) list.add(new Pair(K, j));
            }

            Collections.sort(list);
            plug[list.get(list.size() - 1).y] = false; plug[cur] = true; ans++;
        }

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }
    public static class Pair implements Comparable<Pair> {
        int x, y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pair p){
            return this.x - p.x;
        }
    }
}