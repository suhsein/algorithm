import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw;
    static boolean flag = false;
    static int[] tri = new int[1001];
    static int target, mx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        for(int i = 1; ; i++) {
            tri[i] = tri[i - 1] + i;
            mx = i;
            if(tri[i] >= 1000) break;
        }
        
        int T = Integer.parseInt(br.readLine());
       
        while(T-- > 0) {
            flag = false;
            target = Integer.parseInt(br.readLine());
            eureka(0, 0);
            bw.write(flag ? "1\n" : "0\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void eureka(int cnt, int tot){
        if(cnt == 3) {
            if(tot == target) flag = true;
            return;
        }
        for(int i = 1; i <= mx; i++) 
            eureka(cnt + 1, tot + tri[i]);
    }
}