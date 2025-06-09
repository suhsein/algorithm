class Solution {
    public int lengthOfLIS(int[] nums) {
        // 이분탐색을 이용하는 방법
        // lis 배열을 따로 만든다.
        // lis 배열로 부터 현재 값이 들어갈 최소 인덱스를 찾는다. (초기 인덱스는 lis의 길이)
        // 찾은 인덱스에 현재 값을 넣는다

        List<Integer> lis = new ArrayList<>();
        for(int x : nums) 
            binarySearch(lis, x);

        return lis.size();
    }

    public void binarySearch(List<Integer> lis, int target) {
        int n = lis.size();
        int lo = 0, hi = n - 1, mid;

        if(n == 0 || lis.get(n - 1) < target) {
            lis.add(target);
            return;
        }

        while(lo < hi) {
            mid = (lo + hi) / 2;

            if(lis.get(mid) < target)
                lo = mid + 1;
            else
                hi = mid;
        }

        lis.set(hi, target);
    }
}