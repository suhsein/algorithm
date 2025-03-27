import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main {
    static long[] acc = new long[100001];
    static int N, M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 1; i <= N; i++)
            acc[i] = acc[i - 1] + Long.parseLong(st.nextToken());

        int lo = -1, hi = 1000000001, m;
        while(lo +  1 < hi) {
            m = (lo + hi) / 2;
            if(!ps(m)) hi = m;
            else lo = m;
        }
        
        bw.write(Integer.toString(hi));
        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean ps(int x){
        int cnt = 0;
        
        for(int l = 0, r = 1; l < N; l = r, r++) {
            while(r + 1 <= N && acc[r + 1] - acc[l] <= x) r++;
            if(acc[r] - acc[l] > x) r--;
            cnt++;
            if(cnt > M) return true;
        }

        return (cnt > M);
    }
}