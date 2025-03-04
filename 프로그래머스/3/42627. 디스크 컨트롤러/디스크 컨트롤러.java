import java.util.*;


class Solution {
    public int solution(int[][] jobs) {
        int answer = 0, t = 0, i = 0;
        
        Arrays.sort(jobs, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        
        PriorityQueue<Task> pq = new PriorityQueue<>();
        
        while(i < jobs.length || !pq.isEmpty()){
            if(pq.isEmpty() && jobs[i][0] > t) t = jobs[i][0];
            while(i < jobs.length && jobs[i][0] <= t) {
                pq.add(new Task(jobs[i][1], jobs[i][0]));
                i++;
            }
            if(!pq.isEmpty()){
                Task cur = pq.poll();
                t += cur.takeTime;
                answer += (t - cur.requestTime);
            }
        }
        
        return answer / jobs.length;
    }
}


class Task implements Comparable<Task> {
    public int takeTime;
    public int requestTime;
    
    public Task(int takeTime, int requestTime){
        this.takeTime = takeTime;
        this.requestTime = requestTime;
    }
    
    public int compareTo(Task t){
        if(this.takeTime != t.takeTime)
            return this.takeTime - t.takeTime;
        return this.requestTime - t.requestTime;
    }
}