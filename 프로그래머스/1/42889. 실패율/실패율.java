import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] cnt = new int[N + 2];
        double[] failure = new double[N + 2];
        Pair[] pairs = new Pair[N + 1];
        
        Arrays.sort(stages);
        int x = 1;
        
        for(int i = 0; i < stages.length; i++){
            while (stages[i] != x){
                x++;
            }
            if(stages[i] > N) break;
            cnt[stages[i]]++;
            if ((i + 1 < stages.length && stages[i + 1] != x) || i + 1 == stages.length) {
                failure[stages[i]] = (double)cnt[stages[i]] / (double)(stages.length - i + cnt[stages[i]] - 1);
                pairs[stages[i]] = new Pair(failure[stages[i]], stages[i]);
            }
        }
        
        pairs[0] = new Pair(0.0, N + 1);
        
        for(int i = 1; i <= N; i++) {
            if(pairs[i] == null) {
                pairs[i] = new Pair(failure[i], i);
            }
        }
        Arrays.sort(pairs);
        
        for(int i = 0; i < N; i++) {
            answer[i] = pairs[i].y;
        }
       
        return answer;
    }
}

class Pair implements Comparable<Pair> {
    double x;
    int y;
    
    public Pair(double x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int compareTo(Pair p){
        if(this.x > p.x){
            return -1;
        } else if(this.x == p.x) {
            if(this.y < p.y){
                return -1;
            }
        }
        return 1;
    }
}
