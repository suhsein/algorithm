import java.util.*;

class Solution {
    boolean[] visit = new boolean[9];
    int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        Arrays.fill(visit, false);
        
        for(int i = 0; i < dungeons.length; i++){
            if(k < dungeons[i][0]) continue;
            visit[i] = true;
            bt(k - dungeons[i][1], 1, dungeons);
            visit[i] = false;
        }
        
        return answer;
    }
    
    public void bt(int pirodo, int cnt, int[][] dungeons){
        if(cnt > answer) answer = cnt;
        
        for(int i = 0; i < dungeons.length; i++){
            if(pirodo < dungeons[i][0] || visit[i]) continue;
            visit[i] = true;
            bt(pirodo - dungeons[i][1], cnt + 1, dungeons);
            visit[i] = false;
        }
    }
}