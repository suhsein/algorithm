import java.util.*;

class Solution {
    static int[] answer;
    static Map<String, Integer> map;
    static int[] referIndices;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        
        answer = new int[n];
        map = new HashMap<>();
        referIndices = new int[n];
        
        for(int i = 0; i < n; i++) {
            map.put(enroll[i], i);
            
            if(referral[i].equals("-")) {
                referIndices[i] = -1; // center
                continue;
            }
            
            referIndices[i] = map.get(referral[i]);
        }
       
        pyramid(seller, amount);
        
        return answer;
    }
    
    public void pyramid(String[] seller, int[] amount) {
         for(int i = 0; i < seller.length; i++) {
            int cur = map.get(seller[i]);
            int selled = amount[i] * 100;
            
            int r = referIndices[cur];
            
            int portion = selled / 10;
            answer[cur] += (selled - portion);
            
            while(r != -1 && portion >= 1) {
                answer[r] += (portion / 10 < 1) ? portion : portion - portion / 10;
                portion /= 10;
                cur = r;
                r = referIndices[cur];
            }
        }
    }
}