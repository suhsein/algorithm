class Solution {
    static int answer = -1, x, y;
    
    public int solution(int[] cookie) {
        int N = cookie.length, sum = 0; 
        
        for(int c : cookie) 
            sum += c;
        
        int mx = sum / 2, m = 0;
        
        while(m < N - 1) {
            x = cookie[m];
            y = cookie[m + 1];
            
            int l = m - 1, r = m + 2;
            if(x == y && y > answer) {
                answer = y;
                if(answer == mx) break;
            }
            
            while(true) {
                if(x == y && y > answer) {
                    answer = y;
                    if(answer == mx) break;
                }
                if(l >= 0 && x < y) 
                    x += cookie[l--];
                else if(r < N) 
                    y += cookie[r++];
                else break;
            }
            if(answer == mx) break;
            m++;
        }
        
        return answer == -1 ? 0 : answer;
    }
    
}