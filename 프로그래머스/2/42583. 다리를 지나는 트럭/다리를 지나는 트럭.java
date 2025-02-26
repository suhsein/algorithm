import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int t = 0, sum = 0, i = 0, n = truck_weights.length;
        Queue<Pair> q = new LinkedList<>();
        
        do {
            t++;
            if(!q.isEmpty() && q.peek().t + bridge_length <= t) 
                sum -= q.poll().w;
            if(i < n && sum + truck_weights[i] <= weight){
                sum += truck_weights[i];
                q.add(new Pair(truck_weights[i++],t));
                if(i == n) return t + bridge_length;
            }
        } while(!q.isEmpty());
     
        
        return t;
    }
}

class Pair {
    public int w;
    public int t;
    
    Pair(int w, int t){
        this.w = w;
        this.t = t;
    }
}