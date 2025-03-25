import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw;
    static char[][] arr;
    static boolean[][] visit;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int R, C, ans = 1;
    static boolean[] alphaV;
    
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         bw = new BufferedWriter(new OutputStreamWriter(System.out));
         StringTokenizer st = new StringTokenizer(br.readLine(), " ");
         
         R = Integer.parseInt(st.nextToken());
         C = Integer.parseInt(st.nextToken());
         
         arr = new char[R][C];
         visit = new boolean[R][C];
         alphaV = new boolean['Z' - 'A' + 1]; 
         
         char[] chArr;
         
         for(int i = 0; i < R; i++) {
             chArr = (br.readLine()).toCharArray();       
             for(int j = 0; j < C; j++)
                 arr[i][j] = chArr[j];
         }
         
         alphaV[arr[0][0] - 'A'] = true;
         visit[0][0] = true;
         bt(0,0,1);
            
         bw.write(Integer.toString(ans));
         br.close();
         bw.flush();
         bw.close();
    }
    
    public static void bt(int x, int y, int cnt){
        if(x == R - 1 && y == C - 1) return;
      
        for(int d = 0; d < 4; d++){
            int nx = x + dx[d], ny = y + dy[d];
            if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if(alphaV[arr[nx][ny] - 'A'] || visit[nx][ny]) continue;
            alphaV[arr[nx][ny] - 'A'] = true; visit[nx][ny] = true;
            if(cnt + 1 > ans) ans = cnt + 1; 
            bt(nx, ny, cnt + 1); 
            alphaV[arr[nx][ny] - 'A'] = false; visit[nx][ny] = false;
        }    
    }
}