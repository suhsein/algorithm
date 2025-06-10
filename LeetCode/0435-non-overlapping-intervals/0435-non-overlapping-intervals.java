class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 회의실 배정 그리디 문제
        // 최적해는 빨리 끝나는 회의를 선택하여 최대한 많은 회의를 잡는 것
        // 앞쪽에 더 많은 회의를 배치하기 위해 동일 시간에 끝난다면 더 늦게 시작하는 회의 선택
        
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[1] == o2[1])
                return Integer.compare(o1[0], o2[0]);
            return Integer.compare(o1[1], o2[1]);
        });
        
        int endTime = intervals[0][0], answer = 0;

        for(int[] interval : intervals){ 
            if(interval[0] >= endTime)
                endTime = interval[1];
            else answer++;
        }

        return answer;
    }
}