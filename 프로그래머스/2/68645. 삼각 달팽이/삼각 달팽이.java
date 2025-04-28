import java.util.*;
import java.io.*;

class Solution {
    static int x = 1;
    static boolean[][] visit;
    static int[][] arr;
    public int[] solution(int n) {
        arr = new int[n][n];
        
        int sum = 0, i = -1, j = 0;
        
        for(int a = 1; a <= n; a++) sum += a;
        int[] answer = new int[sum];
        
        while(x <= sum) {
            while(i < n - 1 && arr[i + 1][j] == 0 && x <= sum) arr[++i][j] = x++;
            while(j < n - 1 && arr[i][j + 1] == 0 && x <= sum) arr[i][++j] = x++;
            while(i > 1 && arr[i - 1][j - 1] == 0 && x <= sum) arr[--i][--j] = x++;
        }
        
        int idx = 0;
        
        for(i = 0; i < n; i++) 
            for(j = 0; j <= i; j++)
                answer[idx++] = arr[i][j];
        
        return answer;
    }
    
}