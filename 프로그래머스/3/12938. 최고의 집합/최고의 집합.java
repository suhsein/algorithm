import java.util.*;

class Solution {
    public int[] solution(int n, int s) {    
        if(n > s)
            return new int[] {-1};
        int num = s / n;
        int mod = s % n;
        
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++){
            if(i >= n - mod) answer[i] = num + 1;
            else answer[i] = num;
        }
        
        return answer;
    }
    
}