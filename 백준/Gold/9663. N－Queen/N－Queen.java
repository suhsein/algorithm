import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] arr;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
      
        bw.write(Integer.toString(nQueens(0,0,0,0)));
        br.close();
        bw.flush();
        bw.close();
    }
    
    // 비트마스킹
    // 2의 보수에 의하여, -x = ~x + 1
    // center: 동일 열 / left: 좌하향 대각선 / right: 우하향 대각선
    public static int nQueens(int row, int left, int right, int center){
        if(row == N) return 1;
      
        int ans = 0;
        // 전체 비트로부터 이미 방문한 비트 제외
        int unvisited = ((1 << N) - 1) & ~(left | right | center);
        while(unvisited != 0) {
            // 현재 행에서 선택한 열 (unvisited 중 가장 오른쪽에 있는 비트 찾기)
            int curCol = unvisited & -unvisited;
            // 방문처리
            unvisited -= curCol;
            // 좌하향: 다음 행에서는 현재 열 - 1 선택
            // 우하향: 다음 행에서는 현재 열 + 1 선택
            ans += nQueens(row + 1, (left | curCol) << 1, (right | curCol) >> 1, (curCol | center));
        }
        
        return ans;
    }
}