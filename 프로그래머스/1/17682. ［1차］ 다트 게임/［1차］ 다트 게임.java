class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int mx = dartResult.length() - 1;
        int prev = 0, cur = 0;
        
        for(int i = 0; i <= mx; i++) {
            char c = dartResult.charAt(i);
            prev = cur;
            
            if(c == '0') {
                i++;
                if(i + 1 > mx) {
                    break;
                }
                char nc = dartResult.charAt(i + 1);
                if(nc == '*') {
                    i++;
                    answer += prev;
                } else if(nc == '#') {
                    i++;
                }
                continue;
            } 
            
            char nc = dartResult.charAt(++i);
            int x = c - '0';
            if (nc == '0') {
                nc = dartResult.charAt(++i);
                x = 10;
            }
            
            
            if (nc == 'S') {
                cur = x;
            } else if(nc == 'D'){
                cur = x * x;
            } else if(nc == 'T'){
                cur = x * x * x;
            }
            
        
            if (i + 1 <= mx) {
                nc = dartResult.charAt(i + 1);
                if(nc == '#') {
                    i++;
                    cur = -cur;
                } else if(nc == '*'){
                    i++; 
                    answer += prev;
                    cur *= 2;
                }     
            }    
            answer += cur;
        }
     
        return answer;
    }
}