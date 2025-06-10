class Solution {
    public int maxArea(int[] height) {
        int lo = 0, hi = height.length - 1;
        int answer = 0, w, h;

        while(lo < hi) {
            w = hi - lo;

            if(height[lo] < height[hi]) 
                h = height[lo++];
            else 
                h = height[hi--];

            if(w * h > answer)
                answer = w * h;
        }

        return answer;
    }
}