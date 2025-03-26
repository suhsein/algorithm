import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static long[] arr;
    static long ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new long[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++)
            arr[i] = Long.parseLong(st.nextToken());
        
        
        long lo = -1, hi = 1000000001, m;
        
        while(lo + 1 < hi){
            m = (lo + hi) / 2;
            if(!bs(m)) hi = m;
            else lo = m;
        }
        
        bw.write(Long.toString(lo));
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static boolean bs(long x){
        long tot = 0;
        
        for(int i = 0; i < N; i++) 
            if(arr[i] - x > 0) tot += (arr[i] - x); 

        return tot >= M;
    }
}