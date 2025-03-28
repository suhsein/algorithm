import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        List<ArrayDeque<Integer>> stackList = new ArrayList<>(N + 1);
        for(int i = 0; i<= N; i++) stackList.add(new ArrayDeque<>());
        int ans = 0, a, b, t;
        
        while(N-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            ArrayDeque<Integer> stack = stackList.get(a);
            if(stack.isEmpty() || (!stack.isEmpty() && b > stack.peek())) {
                stack.addFirst(b);
                ans++;
            } else {
                while(!stack.isEmpty() && b < stack.peek()) {
                   t = stack.removeFirst();
                   ans++;
               }
                if(!stack.isEmpty() && b == stack.peek()) continue;
                stack.addFirst(b);
                ans++;
            }
        }
        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }
}