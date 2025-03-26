import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        int x, lo, up; 
        st = new StringTokenizer(br.readLine(), " ");
        
        for(int i = 0; i < M; i++) {
            x = Integer.parseInt(st.nextToken());
           
            lo = lowerBound(x);
            if(lo < 0 || lo >= N || arr[lo] != x) bw.write(0 + " ");
            else {
                up = upperBound(x);
                bw.write(Integer.toString(up - lo) + " ");
            }
        }
       
        br.close();
        bw.flush();
        bw.close();
    }

    public static int lowerBound(int x){
        int lo = -1, hi = N, m = 0;
        
        while(lo + 1 < hi){
            m = (lo + hi) / 2;
            if(arr[m] >= x) hi = m;
            else lo = m;
        }
        return hi;
    }

    public static int upperBound(int x){
        int lo = -1, hi = N, m = 0;

         while(lo + 1 < hi){
            m = (lo + hi) / 2;
            if(arr[m] > x) hi = m;
            else lo = m;
        }
        return hi;
    }
}