import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int i =0;
        while(st.hasMoreTokens()) arr[i++] = Integer.parseInt(st.nextToken());
       
        int[] lis = new int[N];
        lis[0] = arr[0];
        int sz = 0;
        
        for( i = 0; i < N; i++) {
            int idx = Arrays.binarySearch(lis, 0, sz, arr[i]);
            if(idx >= 0) continue;
            idx = Math.abs(idx) - 1;
            lis[idx] = arr[i];
            if(sz == idx) sz++;
        }
       
        System.out.println(sz);
    }
}