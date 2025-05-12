import java.util.*;
import java.io.*;
import java.lang.Math;

class Solution {
    public int solution(int n) {
        return solve(n, 0);
    }
    
    public int solve(int n, int p){
        if(n < 3 || p > 2 * (Math.log(n) / Math.log(3))) return 0;
        if(n == 3){
            if(p == 2) return 1;
            if(p == 3) return 0;
        }
        
        return solve(n - 1, p + 1) + (n % 3 == 0 && p > 1 ? solve(n / 3, p - 2) : 0);
    }
    
}