import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int n = arr.length / 2 + 1;
        int[][] mn = new int[n][n];
        int[][] mx = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            mn[i][i] = Integer.parseInt(arr[i * 2]);
            mx[i][i] = Integer.parseInt(arr[i * 2]);
        }
        
        for(int len = 1; len < n; len++){
            for(int i = 0; i < n - len; i++) {
                int j = i + len;
                mx[i][j] = Integer.MIN_VALUE;
                mn[i][j] = Integer.MAX_VALUE;
                
                for(int k = i; k < j; k++) {
                    String op = arr[k * 2 + 1];
                   
                    int mxLeft = mx[i][k];
                    int mnLeft = mn[i][k];
                    int mxRight = mx[k + 1][j];
                    int mnRight = mn[k + 1][j];
                    
                    if(op.equals("-")) {
                        mx[i][j] = Math.max(mx[i][j], mxLeft - mnRight);
                        mn[i][j] = Math.min(mn[i][j], mnLeft - mxRight);
                    } else {
                        mx[i][j] = Math.max(mx[i][j], mxLeft + mxRight);
                        mn[i][j] = Math.min(mn[i][j], mnLeft + mnRight);
                    } 
                }
            }
        }
        
        return mx[0][n - 1];
    }
}