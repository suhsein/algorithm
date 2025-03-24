import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String str = "", ans = "";
        Deque<Character> stack;
        boolean flag;
        
        while(T-- > 0){
            str = br.readLine();
            flag = true;
            stack = new ArrayDeque<>();
            
            for(char c : str.toCharArray()){
                if(c == '(') stack.addFirst(c);
                else {
                    if(!stack.isEmpty() && stack.peek() == '(') stack.removeFirst();
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            if(!stack.isEmpty()) flag = false;
            ans = flag ? "YES" : "NO";
            System.out.println(ans);
        }
    }
}