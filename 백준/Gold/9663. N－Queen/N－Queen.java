import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main {
    static int N, ans;
    static int[] queens;
    static BufferedWriter bw;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        queens = new int[N];

        nQueens(0);
        
        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void nQueens(int r) {
        if(r == N){
            ans++;
            return;
        }
        for(int i = 0; i < N; i++) { // col
            queens[r] = i;
            if(!visited(r)) nQueens(r + 1); 
        }
    }

    public static boolean visited(int r){
        for(int i = 0; i < r; i++) {
            // 이전 행들에서 이미 방문한 열. 혹은 대각선 (row diff == col diff)
            if(queens[i] == queens[r] || Math.abs(i - r) == Math.abs(queens[i] - queens[r]))
                return true;
        }
        return false;
    }
}