import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        int[][] rgb = new int[N][3];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int j =0;
            while(st.hasMoreTokens()){
                rgb[i][j++] = Integer.parseInt(st.nextToken()); 
            }
        }
        
        int[] prev = new int[3];
        int[] cur = new int[3];
        
        for(int i = 0; i < 3; i++) prev[i] = rgb[0][i];
        
        for(int i = 1; i < N; i++){
            cur[0] = rgb[i][0] + Math.min(prev[1], prev[2]);
            cur[1] = rgb[i][1] + Math.min(prev[0], prev[2]);
            cur[2] = rgb[i][2] + Math.min(prev[0], prev[1]);
            
            for(int j =0; j < 3; j++) prev[j] = cur[j];
        }
        
        System.out.println(Math.min(Math.min(cur[0],cur[1]),cur[2]));
    }
}