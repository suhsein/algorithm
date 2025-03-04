import java.util.*;

class Solution {
    String nums = "";
    Boolean[] visit = new Boolean[8];
    Set<Integer> s = new HashSet<>();
   
    public int solution(String numbers) {
        nums = numbers;
        Arrays.fill(visit, false);
        
        for(int i = 0; i < numbers.length(); i++) {
            if(nums.charAt(i) != '0') {
                visit[i] = true;
                bt(nums.charAt(i) + "");
                visit[i] = false;
            }
        }
        
        return s.size();
    }
    
    public void bt(String tmp){
        Integer x = Integer.parseInt(tmp);
        if(x != 0 && x != 1 && sosu(x)) s.add(x);
        
        for(int i = 0; i < nums.length(); i++) {
            if(visit[i]) continue;
            visit[i] = true;
            bt(tmp + nums.charAt(i) + "");
            visit[i] = false;
        }
    }
    
    public Boolean sosu(Integer x){
        for(int i = 2; i * i <= x; i++)
            if(x % i == 0) return false;
        
        return true;
    }
    
}

