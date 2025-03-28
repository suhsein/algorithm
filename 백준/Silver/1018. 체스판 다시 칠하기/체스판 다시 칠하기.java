import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    static char[][] arr;
    static int[][] WB;
    static int[][] BW;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new char[N + 1][M + 1];
        WB = new int[N + 1][M + 1];
        BW = new int[N + 1][M + 1];
        
        String str;
        
        for(int i = 1; i <= N; i++) {
            str = br.readLine();
            for(int j = 1; j <= M; j++) arr[i][j] = str.charAt(j - 1); 
        }

        // WB
        // 홀수 행, 홀수 열 / 짝수 행, 짝수 열 -> W
        // 그렇지 않으면 모두 B

        // BW
        // 홀수 행, 홀수 열 / 짝수 행, 짝수 열 -> B
        // 그렇지 않으면 모두 W
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                BW[i][j] = BW[i - 1][j] + BW[i][j - 1] - BW[i - 1][j - 1];
                WB[i][j] = WB[i - 1][j] + WB[i][j - 1] - WB[i - 1][j - 1];
                if((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
                    if(arr[i][j] == 'W') BW[i][j]++;
                    else WB[i][j]++;
                } else {
                    if(arr[i][j] == 'W') WB[i][j]++;
                    else BW[i][j]++;
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                for(int a = 0; a + 8 <= i; a++){
                    for(int b = 0; b + 8 <= j; b++){
                        int tmp1 = WB[a + 8][b + 8] - WB[a][b + 8] - WB[a + 8][b] + WB[a][b];
                        int tmp2 = BW[a + 8][b + 8] - BW[a][b + 8] - BW[a + 8][b] + BW[a][b];
                        if(tmp1 < ans) ans = tmp1;
                        if(tmp2 < ans) ans = tmp2;
                    }
                }   
            }
        }

        bw.write(Integer.toString(ans));
        
        br.close();
        bw.flush();
        bw.close();
    }
}