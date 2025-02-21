import java.util.*;

class Solution {
    static int X = 4;
    static int Y = 3;
   
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        Map<Integer, Pair> m = makeMap();
        
        int lPrev = -1, rPrev = -2;
        
        int[] lArr = { 1, 4, 7, -1 };
        int[] rArr = { 3, 6, 9, -2 };
        
        for (int n : numbers) {
            if (Arrays.stream(lArr).anyMatch(x -> x == n)) {
                lPrev = n;
                answer += "L";
            } else if(Arrays.stream(rArr).anyMatch(x -> x == n)) {
                rPrev = n;
                answer += "R";
            } else {
                Pair curPos = m.get(n);
                Pair leftPos = m.get(lPrev);
                Pair rightPos = m.get(rPrev);
                
                int lDist = curPos.dist(leftPos);
                int rDist = curPos.dist(rightPos);
                
                if(lDist < rDist || lDist == rDist && hand.equals("left")) {
                    lPrev = n;
                    answer += "L";
                } else if(lDist > rDist || lDist == rDist && hand.equals("right")) {
                    rPrev = n;
                    answer += "R";
                }
            }
        }
        
        
        return answer;
    }
   
    
    public Map<Integer, Pair> makeMap(){
        Map<Integer, Pair> m = new HashMap<>();
        int key = 0;
        
        for(int i = 0; i < X; i++) {
            for(int j = 0; j < Y; j++) {
                if(i == 3) {
                    if(j == 0) key = -1;
                    else if(j == 1) key = 0;
                    else if(j == 2) key = -2;
                } else key = i * Y + (j + 1);
                m.put(key, new Pair(i , j));
            }
        }
        
        return m;
    }
}

class Pair{
    public int x;
    public int y;
    
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int dist(Pair p){
        return Math.abs(p.x - this.x) + Math.abs(p.y - this.y);
    }
}