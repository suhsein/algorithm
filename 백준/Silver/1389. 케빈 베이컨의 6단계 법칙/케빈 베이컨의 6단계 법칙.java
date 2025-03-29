import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N, M;
    static int[][] arr;
    static int[] kb;
    final static int INF = Integer.MAX_VALUE;
    static int ans = INF, mn = INF;
    
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
    
    public static void solve() {
        floydWarshall();
        for(int i = 1; i <= N; i++) {
            if(kb[i] == mn) {
                ans = i;
                break;
            }
        }    
    }
    
    public static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int a, b;
        arr = new int[N + 1][N + 1];

        for(int i = 0; i <= N; i++) {
            Arrays.fill(arr[i], INF);
            arr[i][i] = 0;
        }
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }

        kb = new int[N + 1];
    }

    public static void floydWarshall(){
        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++){
                    if(i == j || j == k || i == k) continue;
                    if(arr[i][k] == INF || arr[k][j] == INF) continue;
                    int tmp = arr[i][k] + arr[k][j];
                    if(tmp < arr[i][j]) arr[i][j] = tmp;
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++){
                if(i == j) continue;
                kb[i] += arr[i][j];
            }
            if(kb[i] < mn) mn = kb[i];
        }
    }
}