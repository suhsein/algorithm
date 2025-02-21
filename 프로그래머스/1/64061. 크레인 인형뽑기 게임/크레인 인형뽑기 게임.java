import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        List<Queue<Integer>> qList = new ArrayList<>();
        
        int len = board.length;
        
        for(int i = 0; i < len; i++) { 
            Queue<Integer> q = new LinkedList<>();
            for(int j = 0; j < len; j++){
                if(board[j][i] != 0) q.add(board[j][i]);
            }
            qList.add(q);
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        int cnt = 0;
        int prev = 0;
     
        
        for(int x : moves){
            Queue<Integer> cur = qList.get(x - 1);
            if(cur.isEmpty()) continue;
            
            int doll = cur.peek();
            cur.remove();
            
            if(prev == doll) {
                cnt++;
            } else {
                if(cnt != 0) {
                    stack.pop();
                    answer += (cnt + 1);
                    cnt = 0;
                } 
                stack.push(doll);   
            }
            
            while (stack.size() > 1) {
                doll = stack.peek();
                stack.pop();
                
                while (stack.size() > 0) {
                    prev = stack.peek();
                    if(doll == prev) {
                        stack.pop();
                        cnt++;
                    } else {
                        break;
                    }
                }
                if(cnt > 0) {
                    answer += (cnt + 1);
                    cnt = 0;
                } else {
                    stack.push(doll);
                    break;
                }
            }
            prev = stack.isEmpty() ? 0 : stack.peek();
        }
        
        if(cnt > 0) answer += (cnt + 1);
        
        return answer;
    }
}