import java.io.*;
import java.lang.Math;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i = 1; i <= s.length() / 2; i++){
            int x = cut(s, i);
            if(x < answer) answer = x;
        }
        
        return answer;
    }
    
    public static int cut(String s, int sz) {
        String sub = "", cur = "";
        int N = s.length(), cnt = 1, top = 0, res = 0;
        
        for(int i = 0; i < N; i += sz) {
            top = i + sz;
            if(top > N) {
                res += N - i;
                break;
            }
            cur = s.substring(i, top);
            
            if(sub.equals(cur)) cnt++;
            else {
                sub = s.substring(i, top);
                if(i == 0) continue;
                res += sz;
                if(cnt > 1) {
                    res += (int)Math.log10(cnt) + 1;
                }
                cnt = 1;
            }
        }
        
        res += sz;
        if(cnt > 1) {
            res += (int)Math.log10(cnt) + 1;
        }
        
        return res;
    }
}