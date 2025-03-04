import java.util.*;

class Solution {
    int a, b, tmp;
    
    public int solution(int[][] sizes) {
        int s = 1, l = 1;
        
        for(int i = 0; i < sizes.length; i++){
            a = sizes[i][0];
            b = sizes[i][1];
            
            if(b < a) swap();
            
            if(a > s) s = a;
            if(b > l) l = b;
        }
        
        return s * l;
    }
    
    public void swap(){
        tmp = a;
        a = b;
        b = tmp;
    }
}