import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[0] == o2[0])  return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x, idx = 0;
        
        for(int i = 0; i < N; i++) {
            x = Integer.parseInt(st.nextToken());
            pq.add(new int[]{x, i});
        }

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            P[cur[1]] = idx++;
        }

        for(int p : P) bw.write(p + " ");
        bw.flush();
        br.close();
        bw.close();
    }
}