import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    static int A,B,C,M;
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        init();
        
        int day = 24;
        int ans = 0;
        int tired = 0;
        int x = 0;
        
        while(day-- > 0) {
            if(tired + A <= M){
                ans += B;
                tired += A;
            } else {
                tired -= C;
                if(tired < 0) tired = 0;
            }
         }
        
        System.out.println(ans);
    }
    
    public static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }
}