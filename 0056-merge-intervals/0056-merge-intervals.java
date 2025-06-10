class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        List<int[]> answer = new ArrayList<>();

        for (int[] interval : intervals) {
            if (answer.isEmpty() || answer.get(answer.size() - 1)[1] < interval[0])
                answer.add(interval);
            else 
                answer.get(answer.size() - 1)[1] 
                    = Math.max(answer.get(answer.size() - 1)[1], interval[1]);
        }

        return answer.toArray(int[][]::new);
    }
}