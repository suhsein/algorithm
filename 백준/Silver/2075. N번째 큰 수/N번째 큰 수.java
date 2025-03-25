import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
         
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()){
                pq.add(Integer.parseInt(st.nextToken()));
                if(pq.size() <= N) continue;
                pq.poll();
            }
        }
      
        bw.write(Integer.toString(pq.poll()));
            
        br.close();
        bw.flush();
        bw.close();
    }
}