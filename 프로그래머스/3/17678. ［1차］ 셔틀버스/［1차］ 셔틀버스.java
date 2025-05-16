import java.util.*;
import java.time.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        Arrays.sort(timetable);
        
        Queue<LocalTime> q = new LinkedList<>();
        
        for(String s : timetable) 
            q.add(LocalTime.parse(s));
        
        LocalTime arrivalTime = LocalTime.parse("09:00");
        
        int M = m;
        
        while(n-- > 1) {
            M = m;
            
            while((q.peek().equals(arrivalTime) || q.peek().isBefore(arrivalTime)) && M > 0) {
                q.poll();
                M--;
            }
            
            arrivalTime = arrivalTime.plusMinutes(t);
        }
        
        M = m;
        
        if(q.size() >= m) {
            while((q.peek().equals(arrivalTime) || q.peek().isBefore(arrivalTime)) && M > 1) {
                q.poll();
                M--;
            }
            
            LocalTime last = q.poll();
            last = last.plusMinutes(-1);
            
            if(last.isBefore(arrivalTime)) 
                arrivalTime = last;
        } 
        
        return arrivalTime.toString();
    }
    
}