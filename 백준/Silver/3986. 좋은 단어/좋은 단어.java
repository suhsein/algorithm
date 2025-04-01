import java.util.*;
import java.lang.*;
import java.io.*; 

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        String str;
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0; i <  N; i++) {
            str = br.readLine();
            for(char x : str.toCharArray()) {
                if(!stack.isEmpty() && stack.peekFirst() == x) stack.pollFirst();
                else stack.addFirst(x);
            }   
            if(stack.isEmpty()) ans++;
            else stack.clear();
        }

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }
}