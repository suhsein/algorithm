import java.util.*;

class Solution {
    static long MX = 1000000001;
    
    public long solution(int n, int[] times) {
        long l = 0, r = MX * n;
        long m = (l + r) / 2;
        
        while(l <= r) {
            long cnt = 0;
            for(long t : times) cnt += (m / t);
            
            if(cnt >= n) r = m - 1;
            else l = m + 1;
              
            m = (l + r) / 2;
        }
        
        System.out.println("l " + l + " m " + m + " r " + r);
        
        return l;
    }
}