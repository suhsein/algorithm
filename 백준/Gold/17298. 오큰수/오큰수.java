import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        Deque<Pair> stack = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && cur > stack.peekFirst().num) {
                Pair prev = stack.pollFirst();
                ans[prev.idx] = cur;
            }
            stack.addFirst(new Pair(i, cur));
        } 

        for(int x: ans) bw.write(x + " ");
        br.close();
        bw.flush();
        bw.close();
    }

    public static class Pair{
        public int idx, num;
        public Pair(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
}