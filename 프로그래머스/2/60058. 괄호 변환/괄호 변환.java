import java.util.*;

class Solution {
    public String solution(String s) {
        if(s.equals("")) return s;
        
        int n = s.length(), idx = 0, left = 0, right = 0;
        
        Deque<Character> stack = new ArrayDeque<>();
        
        boolean flag = true;
        
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == '(') {
                left++;
                stack.addLast(c);
            }
            if(c == ')') {
                right++;
                if(stack.isEmpty()) flag = false;
                else stack.removeLast();
            }
            if(left != 0 && right != 0 && left == right) {
                idx = i + 1;
                break;
            }
        }
        
        String u = s.substring(0, idx);
        String v = s.substring(idx, n);
        
        if(flag) return u + solution(v);
        
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(solution(v));
        sb.append(")");
        
        for(int i = 1; i < u.length() - 1; i++) {
            char c = u.charAt(i);
            if(c == '(') sb.append(")");
            if(c == ')') sb.append("(");
        }
        
        return sb.toString();
    }
}