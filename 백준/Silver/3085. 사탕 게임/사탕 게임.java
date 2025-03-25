import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main {
    static BufferedWriter bw;
    static int N, ans;
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        String str = "";
        char[] rowArr;
        
        for(int i = 0; i < N; i++) {
            rowArr = (br.readLine()).toCharArray();
            for(int j = 0; j < N; j++) 
                arr[i][j] = rowArr[j];
        }
        
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                
                // col swap
                if(j + 1 < N && arr[i][j] != arr[i][j + 1]){
                    swap(i, j, i, j + 1);
                    count();
                    swap(i, j, i, j + 1);
                }
                
                // row swap
                if(i + 1 < N && arr[i][j] != arr[i + 1][j]) {
                    swap(i, j, i + 1, j);
                    count();
                    swap(i, j, i + 1, j);
                }
            }
        }
        
        bw.write(Integer.toString(ans));
        
        br.close();
        bw.flush();
        bw.close();
    }

    public static void count() {
        int rowCnt = 1, colCnt = 1;
        for(int i = 0; i < N; i++){
            rowCnt = 1; colCnt = 1;
            for(int j = 1; j < N; j++){
                if(arr[i][j - 1] == arr[i][j]) {
                    rowCnt++;
                    if(rowCnt > ans) ans = rowCnt;
                } else rowCnt = 1;
                
                if(arr[j - 1][i] == arr[j][i]) {
                    colCnt++;
                    if(colCnt > ans) ans = colCnt;
                } else colCnt = 1;
            }
        }
    }
    
    public static void swap(int x1, int y1, int x2, int y2){ 
        char tmp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2]= tmp;
    }
   
}