class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        List<Pair> list = new ArrayList<>();
        list.add(new Pair(intervals[0][0], intervals[0][1]));

        for(int[] cur : intervals) {
            if(list.size() == 0 || 
            list.size() > 0 && !(list.get(list.size() - 1).merge(cur[0], cur[1])))
                list.add(new Pair(cur[0], cur[1]));
        }

        return list.stream()
                    .map(p -> new int[]{p.x, p.y})
                    .toArray(int[][]::new);
    }

    public class Pair {
        int x, y;

        // x y z w -> 안겹침 : z > y
        // z w x y -> 안겹침 : w < x
        // x z y w -> 겹침

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public boolean merge(int z, int w) {
            if(z > y) return false;
            if(w < x) return false; 

            this.x = Math.min(x, z);
            this.y = Math.max(y, w);

            return true;
        }
    }
}