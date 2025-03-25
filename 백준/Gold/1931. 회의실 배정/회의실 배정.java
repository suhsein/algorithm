import java.util.*;
import java.io.*;
import java.lang.Comparable;

public class Main {
    static BufferedWriter bw;
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         bw = new BufferedWriter(new OutputStreamWriter(System.out));
         StringTokenizer st;
         List<Pair> list = new ArrayList<>();
         
         int N = Integer.parseInt(br.readLine());
         int x, y;
         
         for(int i = 0; i < N; i++){
             st = new StringTokenizer(br.readLine(), " ");
             x = Integer.parseInt(st.nextToken());
             y = Integer.parseInt(st.nextToken());
             list.add(new Pair(x, y));
         }
         Collections.sort(list);
         
         int end = 0, ans = 0;
         
         for(Pair p : list){
             if(p.x >= end) {
                 end = p.y;
                 ans++;
             }    
         }
         
         bw.write(Integer.toString(ans));
         br.close();
         bw.flush();
         bw.close();
    }
    
    public static class Pair implements Comparable<Pair>{
        int x, y;
        
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public int compareTo(Pair p){
            if(this.y == p.y) return this.x - p.x;
            return this.y - p.y;
        }
    }
}