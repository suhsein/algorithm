import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N, M;
    static int[][] arr;
    static int[][] acc;
    static int ans = 0;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        acc = new int[N + 1][M + 1];
        String str;
        
        for(int i = 1; i <= N; i++) {
            str = br.readLine();
            for(int j = 1; j <= M; j++){
                arr[i][j] = str.charAt(j - 1) - '0';
                if(arr[i][j] == 1) 
                    acc[i][j] = Math.min(Math.min(acc[i - 1][j - 1], acc[i - 1][j]), acc[i][j - 1]) + 1;
                ans = Math.max(ans, acc[i][j]);
            }
        }
        
        bw.write(Integer.toString(ans * ans));
        bw.flush();
        br.close();
        bw.close();
    }
}