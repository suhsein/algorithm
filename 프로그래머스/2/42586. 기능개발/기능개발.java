import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int n = progresses.length;
       
        for(int i = 0; i < n; i++){
            int r = 100 - progresses[i];
            int t = r / speeds[i];
            if(r % speeds[i] != 0) t++;
            
            int tmp = i + 1;
        
            for(int j = i + 1; j < n; j++){
                int nr = 100 - progresses[j];
                int nt = nr / speeds[j];
                if(nr % speeds[j] != 0) nt++;
                if (t < nt) break;
                tmp++;
            }
        
            answer.add(tmp - i);
            i = tmp - 1;
        }
        
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}