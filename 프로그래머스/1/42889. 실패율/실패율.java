import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Arrays.sort(stages);
        List<Stage> list = new ArrayList<>();
        
        int uncleared = 0, reached = stages.length, idx = 1;
        
        for(int s : stages) {
            while(idx < s) {
                list.add(new Stage(idx, uncleared, reached));
                reached -= uncleared;
                uncleared = 0; idx++;
            }
            uncleared++;
        }
        while(idx <= N) {
            list.add(new Stage(idx++, uncleared, reached));
            uncleared = 0;
        }
        
        Collections.sort(list);
        int n = list.size();
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++) 
            answer[i] = list.get(i).stageNum;
        
        return answer;
    }
    public static class Stage implements Comparable<Stage> {
        int stageNum;
        int uncleared;
        int reached;
        
        public Stage(int stageNum, int uncleared, int reached){
            this.stageNum = stageNum;
            this.uncleared = uncleared;
            this.reached = reached;
        }
        
        public int compareTo(Stage s){
            double tf = (double)this.uncleared / this.reached;
            double sf = (double)s.uncleared / s.reached;
            
            if(tf == sf) return this.stageNum - s.stageNum;
            return Double.compare(sf, tf);
        }
    }
}