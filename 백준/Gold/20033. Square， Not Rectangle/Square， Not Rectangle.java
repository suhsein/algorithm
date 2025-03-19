import java.util.*;
import java.io.*;

public class Main {
    static int MX = 300001;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int N = Integer.parseInt(br.readLine());
        long[] arr = new long[MX];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        long l = -1, r = 1000000001, m;
        
        while(l + 1 < r) {
            m = (l + r) / 2;
            if(!check(m, arr)) r = m;
            else l = m;
        }
        
        System.out.println(l);
	}
    
    public static boolean check(long x, long[] arr){
        long cnt = 0;
        for(long a : arr) {
            if(a < x) cnt = 0;
            else cnt++;
            if(cnt >= x) return true;
        }
        return false;
    }
}