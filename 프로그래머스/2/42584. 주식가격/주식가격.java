import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> st = new Stack<>();
    
        for(int i = 0; i < n; i++) {
            if(st.isEmpty()) {
                st.push(i);
                continue;
            }
            int p = prices[i];
            if (p >= prices[st.peek()]) st.push(i);
            else {
                while(!st.isEmpty() && p < prices[st.peek()]) {
                    int t = st.pop();
                    answer[t] = i - t;
                }
                st.push(i);
            }
        }
        
        while(!st.isEmpty()){
            int t = st.pop();
            answer[t] = n - t - 1;
        }
        
        return answer;
    }
}