import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int ans = Integer.MAX_VALUE;
        
        int[] dp = new int[N + 1];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++){
            int x = Integer.parseInt(st.nextToken());
            dp[i] = dp[i - 1] + x;
        }
        
        for(int l = 0, r = 0; l <= N; l++){
            while(r <= N && dp[r] - dp[l] < S) r++;
            if(r > N) break;
            ans = Math.min(ans, r - l);
        }
        if(ans == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(ans);
    }
}