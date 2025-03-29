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

        init();
        solve();
        
        bw.write(Integer.toString(ans));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void calc(int i, int j){
        int a = i - 1, b = j - 1;
        int len = 1;
        
        while(i <= N && j <= M) {
            int area = acc[i][j] - acc[a][j] - acc[i][b] + acc[a][b];
            if(area != len * len) return;
            i++; j++; len++;
            if(area > ans) ans = area;
        }
    }

    public static void solve() {
       for(int i = 1; i <= N; i++)
            for(int j = 1; j <= M; j++)
                if(arr[i][j] == 1) calc(i, j);
    }
    
    public static void init() throws IOException {
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
                acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1] + arr[i][j];
            }
        }
    }    
}