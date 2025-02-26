import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(c.equals(')')){
                if(st.isEmpty()) return false;
                if(st.peek().equals('(')) st.pop();
            } else st.push(c);
        }
        
        
        if(!st.isEmpty()) return false;
        
        return true;
    }
}