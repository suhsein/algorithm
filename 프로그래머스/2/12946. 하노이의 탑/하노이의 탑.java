import java.io.*;
import java.util.*;

class Solution {
    static List<Pair> list = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoi(1, 3, n);
        int[][] answer = new int[list.size()][2];
        
        for(int i = 0; i < list.size(); i++){
            Pair cur = list.get(i);
            answer[i] = new int[] {cur.a, cur.b};
        }
        
        return answer;
    }
    
    public void hanoi(int a, int b, int n) {
        if(n == 1) {
            list.add(new Pair(a,b));
            return;
        }
        
        hanoi(a, 6 - a - b, n - 1);
        list.add(new Pair(a, b));
        hanoi(6 - a - b, b, n - 1);
    }
    
    public static class Pair {
        int a, b;
        public Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
}