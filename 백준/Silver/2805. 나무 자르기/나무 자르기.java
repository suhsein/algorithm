import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
       
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        str = br.readLine();
        st = new StringTokenizer(str, " ");
        
        long[] arr = new long[N];
        int i = 0;
        long lo = -1, hi = 1000000001, m; 
        
        while(st.hasMoreTokens()) {
            arr[i++] = Long.parseLong(st.nextToken());
            if(arr[i-1] > hi) hi = arr[i-1]; 
        }
        
        hi++;
            
        br.close();
       
        while(lo + 1 < hi) {
            m = (lo + hi) / 2;
            if(!check(m, M, arr)) hi = m;
            else lo = m;
        }
        
        System.out.println(lo);
    }
    
    public static boolean check(long h, int M, long[] arr){
        long sum = 0;
        for(long a : arr) {
            if(a > h) sum += (a - h);
            if(sum >= M) return true;
        }
        return false;
    }
}