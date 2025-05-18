import java.util.*;

class Solution {
    public int solution(String[] lines) {        
        List<Job> jobs = new ArrayList<>();
        
        for(String line : lines) {
            String[] splits = line.split(" ");
            long endTime = convertToMilliSeconds(splits[1]);
            long startTime = endTime 
                - (long) (Double.parseDouble(splits[2].replace("s", "")) * 1000) + 1;
            jobs.add(new Job(startTime, endTime));
        }

        
        int answer = 1;
        
        for(int i = 0; i < jobs.size(); i++) {
            int cnt = 0;
            long open = jobs.get(i).endTime;
            
            for(Job job : jobs) {
                if(job.endTime >= open && job.startTime < (open + 1000)) 
                    cnt++;    
            }
            
            if(cnt > answer) answer = cnt;
        }
        
        return answer;
    }
    
    public long convertToMilliSeconds(String time){
        long ret = 0;
        String[] splits = time.split(":");
        
        ret += Integer.parseInt(splits[0]) * 60 * 60;
        ret += Integer.parseInt(splits[1]) * 60;
        ret *= 1000;
        ret += (long)(Double.parseDouble(splits[2]) * 1000);
        
        return ret;
    }
    
    public class Job {
        long startTime, endTime;
        
        public Job(long startTime, long endTime) {
            this.startTime = startTime; 
            this.endTime = endTime;
        }
    }
}