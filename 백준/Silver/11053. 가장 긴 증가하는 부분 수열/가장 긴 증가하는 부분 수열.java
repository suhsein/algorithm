import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int i =0;
        while(st.hasMoreTokens()) arr[i++] = Integer.parseInt(st.nextToken());
       
        int[] lis = new int[N];
        int sz = 0;
        
        for(i = 0; i < N; i++) {
            int idx = lowerBound(lis, sz, arr[i]);
            lis[idx] = arr[i];
            if(idx == sz) sz++;
        }
    
        System.out.println(sz);
    }
    public static int lowerBound(int[] lis, int sz, int cur) {
        int lo = -1, hi = sz, m;
        while(lo + 1 < hi){
            m = (lo + hi) / 2;
            if(lis[m] < cur) lo = m;
            else hi = m;
        }
        return hi;
    }
}