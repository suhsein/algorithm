import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int[] dp = new int[100005];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            dp[i] = i;
            for(int j = 1; j * j <= i; j++) dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
        }

        br.close();
        bw.write(Integer.toString(dp[N]));
        bw.flush();
        bw.close();
    }
}