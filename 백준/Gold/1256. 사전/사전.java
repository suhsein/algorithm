import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static String ans;
    static int[][] dp;
    static int N, M, K, idx = 0;
    static boolean found = false;
    static StringBuilder sb = new StringBuilder();
    static int MAX = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[101][101];

        for(int j = 1; j <= M; j++) dp[0][j] = 1; // z로만 구성
        for(int i = 1; i <= N; i++) {
            dp[i][0] = 1; // a로만 구성
            for(int j = 1; j <= M; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // a로 시작하는 경우 + z로 시작하는 경우      
                if(dp[i][j] > MAX) dp[i][j] = MAX;
            }
        }

        if(dp[N][M] < K) ans = "-1";
        else ans = find(N, M, K);
        
        
        bw.write(ans);
        br.close();
        bw.flush();
        bw.close();
    }
    public static String find(int a, int z, int k){
        if(a == 0) {
            sb.append("z".repeat(z));
            return sb.toString();
        } 
        if(z == 0) {
            sb.append("a".repeat(a));
            return sb.toString();
        } 
        if(dp[a - 1][z] >= k) { // a로 시작하는 경우
            sb.append("a");
            find(a - 1, z, k);
            return sb.toString();
        }
        else { // z로 시작하는 경우
            sb.append("z");
            find(a, z - 1, k - dp[a - 1][z]); // a로 시작하는 모든 경우 다음에 z로 시작하는 경우 옴
            return sb.toString();
        }
    }
    
}