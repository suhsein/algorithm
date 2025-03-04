class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int yw = yellow, yh = 1, sum = brown + yellow;
        
        for(int i = 1; i <= sum; i++) {
            if(yellow % i == 0) {
                yw = yellow / i;
                yh = i;
                if(yh > yw) break;
                if((yw + 2) * (yh + 2) == sum) {
                    answer[0] = yw + 2;
                    answer[1] = yh + 2;
                }
            }
        } 
        
        return answer;
    }
}