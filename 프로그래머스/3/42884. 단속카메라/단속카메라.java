import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
            
        Arrays.sort(routes, (r1, r2) -> r1[1] - r2[1]);
        
        int cam = -30005;
        
        for(int[] r : routes){
            if(cam < r[0]){
                cam = r[1];
                answer++;
            }
        }
        
        return answer;
    }
}
