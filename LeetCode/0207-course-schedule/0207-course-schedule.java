class Solution {
    // testtesttest
    static int[] p;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] idg = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int[] pre : prerequisites){
            idg[pre[0]]++;
            List<Integer> list = adj.getOrDefault(pre[1], new ArrayList<>());
            list.add(pre[0]);
            adj.put(pre[1], list);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(idg[i] == 0) {
                visit[i] = true;
                q.add(i);
            }
        }

        if(q.isEmpty())
            return false;
    
        while(!q.isEmpty()) {
            int cur = q.poll();
            visit[cur] = true;

            List<Integer> list = adj.get(cur);

            if(list == null) continue;
            for(int nxt : list) {
                if(visit[nxt]) continue;
                idg[nxt]--;
                if(idg[nxt] == 0) q.add(nxt);
            }
        }

        for(int i = 0; i < numCourses; i++)
            if(!visit[i]) return false;
        
        return true;
    }

}