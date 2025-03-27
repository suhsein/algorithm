import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main {
    static int[] dp = new int[1001];
    static final int MOD = 10007;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());

        // 가로가 i인 경우 2x1, 1x2 타일
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
            
        bw.write(Integer.toString(dp[n] % MOD));

        br.close();
        bw.flush();
        bw.close();
    }
    
   
}