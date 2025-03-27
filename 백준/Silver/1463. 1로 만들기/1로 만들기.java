import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main {
    static int[] memo = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int x = Integer.parseInt(br.readLine());
        bw.write(Integer.toString(makeOne(x)));

        br.close();
        bw.flush();
        bw.close();
    }
    
    public static int makeOne(int x) {
        if(memo[x] != 0) return memo[x];
        if(x == 1) return memo[x] = 0;
        if(x % 6 == 0) memo[x] = Math.min(makeOne(x / 2), makeOne(x / 3)) + 1;
        else {
           memo[x] = makeOne(x - 1) + 1;
           if(x % 3 == 0) memo[x] = Math.min(memo[x], makeOne(x / 3) + 1);
           if(x % 2 == 0) memo[x] = Math.min(memo[x], makeOne(x / 2) + 1);
        }
        return memo[x];
    }
}