import java.util.*;

class Solution {
    int n;
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        n = progresses.length;
       
        int[] days = getDays(progresses, speeds);
        
        int cur = 0, nxt = cur + 1;
        
        while(nxt < n){
          if(days[cur] >= days[nxt]) {
              nxt++;
          } else {
              answer.add(nxt - cur);
              cur = nxt;
              nxt = cur + 1;
          }
        }
        answer.add(nxt - cur);
        
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    public int[] getDays(int[] progresses, int[] speeds){
        int[] days = new int[n];
         for(int i = 0; i < n; i++){
            int r = 100 - progresses[i];
            int t = r / speeds[i];
            if(r % speeds[i] != 0) t++;
            days[i] = t;
         }
        return days;
    }
}