import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1, o = 0;
        
        List<Integer> ord = Arrays.stream(priorities).boxed().collect(Collectors.toList());
        Collections.sort(ord, Collections.reverseOrder());
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++)
            q.add(new Pair(i, priorities[i]));
        
        while(!q.isEmpty()){
            Pair cur = q.poll();
            
            if(cur.priority == ord.get(o)){
                if(cur.idx == location) return answer;
                o++;
                answer++;
            } else q.add(cur);
        }
        
        return answer;
    }
}

class Pair {
    public int idx; 
    public int priority;
    
    Pair(int idx, int priority){
        this.idx = idx;
        this.priority = priority;
    }
}