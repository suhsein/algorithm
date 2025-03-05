import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        boolean[] l = new boolean[n + 2];
        boolean[] r = new boolean[n + 2];
        
        for(int x : lost)
            l[x] = true;
        for(int x : reserve)
            r[x] = true;
        
        for(int i = 1; i <= n; i++) {
            if(l[i] && r[i]) {
                l[i] = r[i] = false;
                answer++;
            }
        }
        
        for(int i = 1; i <= n; i++){
            if(!l[i]) continue;
            if(r[i - 1]) {
                r[i - 1] = false;
                answer++;
            } else if(r[i + 1]) {
                r[i + 1] = false;
                answer++;
            }
        }
        
        
        return answer;
    }
}