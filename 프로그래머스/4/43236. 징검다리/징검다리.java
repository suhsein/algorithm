import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {   
        if(rocks.length == n) return distance;
        
        Arrays.sort(rocks);
       
        int lo = 0, hi = distance + 1, m = 0;
      
        while(lo + 1 < hi) {
            m = (lo + hi) / 2;
            
            if(check(m, n, distance, rocks)) hi = m;
            else lo = m;
        }
        
        return lo;
    }
    
    public boolean check(int m, int n, int distance, int[] rocks) {
        int cnt = 0, prev = 0;
        
        for(int r : rocks) {
            if(r - prev < m) cnt++;
            else prev = r;
            if(cnt > n) return true;
        }
        if(distance - prev < m) cnt++;
        return cnt > n;
    }
}