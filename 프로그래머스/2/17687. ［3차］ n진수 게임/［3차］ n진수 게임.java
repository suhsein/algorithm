import java.io.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        
        String s = "";
        int num = 0, idx = 0, cnt = 0;
        p--;
        
        while(true) {
            while (idx >= s.length()) s += Integer.toString(num++, n).toUpperCase();
            char c = s.charAt(idx);
            if(idx % m == p) {
                sb.append(c);
                cnt++;
                if(cnt == t) break;
            }
            idx++;
        }
        
        return sb.toString();
    }
}