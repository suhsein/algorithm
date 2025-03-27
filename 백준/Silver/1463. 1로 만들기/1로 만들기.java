import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main {
    static int[] memo = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int x = Integer.parseInt(br.readLine());
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = memo[1] = 0;
        
        for(int i = 2; i <= x; i++){
            memo[i] = memo[i - 1] + 1;
            if(i % 2 == 0) memo[i] = Math.min(memo[i], memo[i / 2] + 1);
            if(i % 3 == 0) memo[i] = Math.min(memo[i], memo[i / 3] + 1);
        }

        bw.write(Integer.toString(memo[x]));
        br.close();
        bw.flush();
        bw.close();
    }
}