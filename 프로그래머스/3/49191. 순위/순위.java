import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] matches = new boolean[n + 1][n + 1];
        
        for(int[] r : results)
            matches[r[0]][r[1]] = true;
        
        
        for(int k = 1; k <= n; k++)
            for(int i = 1; i <= n; i++)
                for(int j = 1; j <= n; j++)
                    if(matches[i][k] && matches[k][j]) matches[i][j] = true;
      
        boolean flag;
    
        for(int i = 1; i <= n; i++) {
            flag = true;
            for(int j = 1; j <= n; j++){
                if(i == j) continue;
                if(!(matches[i][j] || matches[j][i])) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        
        return answer;
    }
}