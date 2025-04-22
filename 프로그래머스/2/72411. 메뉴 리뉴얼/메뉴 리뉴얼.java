import java.util.*;
import java.io.*;

class Solution {
    final static int SIZE = 'Z' - 'A' + 1;
    static int n;
    static int[] binaryOrders;
    static int[] mx;
    static boolean[] inc;
    static List<Course> bins = new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
        n = orders.length;
        binaryOrders = new int[n];
        inc = new boolean[SIZE + 1];
        mx = new int[11];
        
        int tmp = 0, b = 0;
        for(int i = 0; i < n; i++) {
            tmp = 0;
            for(char c : orders[i].toCharArray()) {
                b = c - 'A';
                inc[b] = true;
                tmp |= (1 << b);
            }
            binaryOrders[i] = tmp;
        }
        
        composition(0, 0, 0, course);
        StringBuilder sb = new StringBuilder();
        
        List<String> answer = new ArrayList<>();
        
        for(int i = 0; i < bins.size(); i++){
            Course p = bins.get(i);
            if(p.o < mx[p.cnt]) continue;

            for(int j = 0; j < SIZE; j++) {
                b = (1 << j);
                if((p.mask & b) == b) {
                    char ct = (char) (j + 'A');
                    sb.append(ct);
                }
            }
            answer.add(sb.toString());
            sb.setLength(0);
        }
        
                
        return answer.toArray(new String[0]);
    }
    
    public static void composition(int mask, int idx, int cnt, int[] course) {
        for(int i = 0; i < course.length; i++) {
            if(cnt < course[0]) break;
            int c = course[i];
            if(cnt != c) continue;
            
            int o = 0;
            for(int j = 0; j < n; j++)  
                if((mask & binaryOrders[j]) == mask) o++;
            if(o >= 2) {
                bins.add(new Course(mask, cnt, o));
                if(o > mx[c]) mx[c] = o;
            }
            if(i == course.length - 1) return;
        }
       
        for(int i = idx; i < SIZE; i++) {
            if(!inc[i]) continue;
            composition((mask | (1 << i)), i + 1, cnt + 1, course);
        }
    }
    
    public static class Course {
        int mask;
        int cnt;
        int o;
        
        public Course(int mask, int cnt, int o){
            this.mask = mask;
            this.cnt = cnt;
            this.o = o;
        }   
    }
}