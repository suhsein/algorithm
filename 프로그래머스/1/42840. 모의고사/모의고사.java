import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        List<Integer> ret = new ArrayList<>();
        
        int[][] pick = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        
        for(int i = 0; i < answers.length; i++) {
            if(pick[0][i % 5] == answers[i]) answer[0]++;
            if(pick[1][i % 8] == answers[i]) answer[1]++;
            if(pick[2][i % 10] == answers[i]) answer[2]++;
        }
        
        int mx = Arrays.stream(answer).max().getAsInt();
        
        for(int i = 0; i < 3; i++) if(answer[i] == mx) ret.add(i + 1);
        
        return ret.stream().mapToInt(i->i).toArray();
    }
}