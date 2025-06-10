class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] min = new int[n];
        min[0] = prices[0];

        for(int i = 1; i < n; i++) 
            min[i] = (prices[i] < min[i - 1]) ? prices[i] : min[i - 1];
        
        int answer = 0;

        for(int i = 1; i < n; i++) {
            int tmp = prices[i] - min[i - 1];
            if(tmp > answer)
                answer = tmp;
        }

        return answer;
    }
}