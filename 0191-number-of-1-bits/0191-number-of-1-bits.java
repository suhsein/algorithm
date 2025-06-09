class Solution {
    public int hammingWeight(int n) {
        int answer = 0;

        while(n > 0) {
            answer += (n & 1);
            n >>= 1;
        }
        
        return answer;
    }
}