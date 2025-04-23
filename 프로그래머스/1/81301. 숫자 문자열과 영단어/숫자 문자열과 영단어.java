import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        char c, d;
        for(int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(c >= '0' && c <= '9') sb.append(c);
            else {
                if(c == 'z') {
                    sb.append('0');
                    i += 3;
                } else if(c == 'o') {
                    sb.append('1');
                    i += 2;
                } else if(c == 't') {
                    d = s.charAt(++i);
                    if(d == 'w') sb.append('2');
                    else if(d == 'h') {
                        sb.append('3');
                        i += 2;
                    }
                    i++;
                } else if(c == 'f') {
                    d = s.charAt(++i);
                    if(d == 'o') sb.append('4');
                    else if(d == 'i') sb.append('5');
                    i += 2;
                } else if(c == 's') {
                    d = s.charAt(++i);
                    if(d == 'i') sb.append('6');
                    else if(d == 'e') {
                        sb.append('7');
                        i += 2;
                    }
                    i++;
                } else if(c == 'e') {
                    sb.append('8');
                    i += 4;
                } else if(c == 'n') {
                    sb.append('9');
                    i += 3;
                }
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
}