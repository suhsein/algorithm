class Solution {
    public int[] countBits(int n) {
        int[] answer = new int[n + 1];
        int tmp = n;

        while(n > 0) {
            while(tmp > 0) {
                tmp &= (tmp - 1);
                answer[n]++;
            }

            tmp = --n;
        }

        return answer;
    }
}