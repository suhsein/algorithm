class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int c = Integer.valueOf(Integer.toString(a) + Integer.toString(b));
        int d = Integer.valueOf(Integer.toString(b) + Integer.toString(a));
    
        if(Integer.valueOf(c) > Integer.valueOf(d)){
            answer = c; 
        } else {
            answer = d;
        }
        return answer;
    }
}