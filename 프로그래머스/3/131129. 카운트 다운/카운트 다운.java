import java.util.*;

class Solution {
    public int[] solution(int target) {
        Map<Integer, Type> map = new HashMap<>();
        map.put(0, new Type(0,0,0,0));
        
        Type cur, prev;
        
        for(int i = 1; i <= target; i++){
            cur = new Type(100000,100000,100000,100000);
            
            if(i <= 20) 
                cur.update(1,0,0,0);
            else if(i == 50)
                cur.update(0,1,0,0);
            else {
               for(int j = 1; j <= 20; j++) { 
                   if(i - j * 2 >= 0) { // double
                        prev = map.get(i - j * 2);
                        if(prev != null && cur.getTotal() > prev.getTotal() + 1) 
                            cur.update(prev.sg, prev.bull, prev.db + 1, prev.trp);
                    }
                   
                    if(i - j * 3 >= 0) { // triple
                        prev = map.get(i - j * 3);
                        if(prev != null && cur.getTotal() > prev.getTotal() + 1)
                            cur.update(prev.sg, prev.bull, prev.db, prev.trp + 1);
                    }  
                   
                   if(i - j >= 0) { // single
                        prev = map.get(i - j);
                        if(prev != null && cur.getTotal() >= prev.getTotal() + 1)
                            cur.update(prev.sg + 1, prev.bull, prev.db, prev.trp);
                    }
               }
             
                
                if(i - 50 >= 0) { // bullseye
                    prev = map.get(i - 50);
                    if(prev != null && cur.getTotal() >= prev.getTotal() + 1) 
                        cur.update(prev.sg, prev.bull + 1, prev.db, prev.trp);
                }
            }
            
            map.put(i, cur);
            cur = map.get(i);
        }
        
        cur = map.get(target);
        
        int[] answer = new int[2];
        answer[0] = cur.getTotal();
        answer[1] = cur.sg + cur.bull;
        
        return answer;
    }
    
    public class Type { 
        int sg, bull, db, trp;
        
        public Type(int sg, int bull, int db, int trp) {
            this.sg = sg;
            this.bull = bull;
            this.db = db;
            this.trp = trp;
        }
        
        public void update(int sg, int bull, int db, int trp){
            this.sg = sg;
            this.bull = bull;
            this.db = db;
            this.trp = trp;
        }
        
        public int getTotal(){
            return this.sg + this.bull + this.db + this.trp;
        }
    }
}