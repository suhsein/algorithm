import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[][] places) {
        int n = places.length;
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++)
            answer[i] = valid(places[i]);
        
        return answer;
    }
    
    public int valid(String[] places) {
        List<Pair> list = new ArrayList<>();
        
        for(int i = 0; i < 5; i++) 
            for(int j = 0; j < 5; j++)
                if(places[i].charAt(j) == 'P') 
                    list.add(new Pair(i, j));
            
        
        Collections.sort(list, (p1, p2) -> {
            if(p1.x == p2.x) return p1.y - p2.y;
            return p1.x - p2.x;
        });
        
        for(int i = 0; i < list.size(); i++) {
            for(int j = i + 1; j < list.size(); j++) {
                Pair p1 = list.get(i);
                Pair p2 = list.get(j);
                
                int manhattan = Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
                if(manhattan > 2) continue;
                if(manhattan == 1) return 0;
                if(p1.x == p2.x && places[p1.x].charAt(p1.y + 1) != 'X')
                    return 0;
                if(p1.y == p2.y && places[p1.x + 1].charAt(p1.y) != 'X')
                    return 0;
                int diff = p2.x - p1.x;
                if(diff == 1 && diff == p2.y - p1.y
                  && (places[p1.x].charAt(p1.y + 1) != 'X' 
                       || places[p1.x + 1].charAt(p1.y) != 'X')) 
                    return 0;
                if(diff == 1 && diff == p1.y - p2.y
                   && (places[p1.x].charAt(p1.y - 1) != 'X' 
                   || places[p1.x + 1].charAt(p1.y) != 'X')) 
                    return 0;   
            }
        }
        return 1;
    }
    
    public static class Pair {
        int x, y;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public String toString(){
            return this.x + " " + this.y;
        }
    }
}