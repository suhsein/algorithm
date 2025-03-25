import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> st = new ArrayDeque<>();
        
        for(char c : str.toCharArray()){
            if(c >= 'A' && c <= 'Z') {
                sb.append(c);
                continue;
            }
            if(c == '(') {
                st.addFirst(c);
                continue;
            }
            if(c == ')') {
                while(!st.isEmpty()){
                    char tmp = st.removeFirst();
                    if(tmp == '(') break;
                    sb.append(tmp);
                }
                continue;
            }
            while(!st.isEmpty() && priority(c) <= priority(st.peekFirst())) 
                sb.append(st.removeFirst());
            st.addFirst(c);
        }
        while(!st.isEmpty()) sb.append(st.removeFirst());
        bw.write(sb.toString());
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static int priority(char c) {
        switch(c) {
            case '(': case ')': return 0;
            case '+': case '-': return 1;
            case '*': case '/': return 2;
        }
        return -1;
    }
}