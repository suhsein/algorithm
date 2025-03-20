import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {   
        if(rocks.length == n) return distance;
        
        Arrays.sort(rocks);
       
        int lo = 0, hi = distance + 1, m = 0, cnt = 0, prev = 0;
      
        while(lo + 1 < hi) {
            m = (lo + hi) / 2;
            cnt = 0; prev = 0;
            
            for(int r : rocks) {
                if(r - prev < m) cnt++;
                else prev = r;
            }
            
            if(distance - prev < m) cnt++;
            if(cnt > n) hi = m;
            else lo = m;
        }
        
        return lo;
    }
}