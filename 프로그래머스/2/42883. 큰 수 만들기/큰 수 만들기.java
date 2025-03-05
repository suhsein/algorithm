import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int len = number.length(), cnt = 0;
        
        for(char x : number.toCharArray()) {
            if(answer.equals("")) {
                answer += (x + "");
                continue;
            }
            int cur = Integer.parseInt(x + "");
           
            while(answer.length() > 0){
                int prev = Integer.parseInt(answer.charAt(answer.length() - 1) + "");
            
                if(prev < cur && cnt < k) {
                    answer = answer.substring(0, answer.length() - 1);
                    cnt++;
                } else break;
            }
             answer += (x + "");
        }

        if(cnt < k) answer = answer.substring(0, answer.length() - (k - cnt));
        
        return answer;
    }
}