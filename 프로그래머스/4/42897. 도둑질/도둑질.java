import java.util.*;

class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int[] first = new int[n];
        int[] second = new int[n];
        
        for(int i = 0; i < n; i++) {
            first[i] = money[i];
            second[i] = money[i];
        }
        
        first[1] = second[0] = -1;
        first[2] += first[0];
        for(int i = 3; i < n; i++){
            first[i] += Math.max(first[i - 2], first[i - 3]);
            second[i] += Math.max(second[i - 2], second[i - 3]);
        }
        
        int fm = Math.max(first[n - 2], first[n - 3]);
        int sm = Math.max(second[n - 1], second[n - 2]);
        
        return Math.max(fm, sm);
    }
}