import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1];
        int ans = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++){
            int mxidx = 0;
            for(int j = i - 1; j >= 0; j--) if(dp[j] > dp[mxidx] && arr[i] > arr[j]) mxidx = j;
            dp[i] = dp[mxidx] + arr[i];
            if(dp[i] > ans) ans = dp[i];
        }

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }
}