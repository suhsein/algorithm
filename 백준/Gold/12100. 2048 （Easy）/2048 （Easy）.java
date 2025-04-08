import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        br.close();
        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
    }

    public static void moveBlocks(int d) {
        if(d == 0) {
            // 위로
            for(int i = 0; i < N; i++) { // 열 0번부터
                Deque<Integer> stack = new ArrayDeque<>();
                
                for(int j = 0; j < N; j++) { // 행 0번부터
                    if(map[j][i] == 0) continue;
                    if(!stack.isEmpty() && map[j][i] == stack.peekFirst()){
                        stack.addFirst(stack.pollFirst() * 2);   
                        stack.addFirst(-1);
                    }
                    else stack.addFirst(map[j][i]);
                }
    
                int idx = 0;
                while(!stack.isEmpty()) {
                    int x = stack.pollLast();
                    if(x == -1) continue;
                    if(x > ans) ans = x;
                    map[idx++][i] = x;
                }
                while(idx < N)
                    map[idx++][i] = 0;
            }
        } else if(d == 1){
             // 아래로
            for(int i = 0; i < N; i++) { 
                Deque<Integer> stack = new ArrayDeque<>();
                
                for(int j = N - 1; j >= 0; j--) { 
                    if(map[j][i] == 0) continue;
                    if(!stack.isEmpty() && map[j][i] == stack.peekFirst()){
                        stack.addFirst(stack.pollFirst() * 2);
                        stack.addFirst(-1);
                    }
                    else stack.addFirst(map[j][i]);
                }
    
                int idx = N - 1;
                while(!stack.isEmpty()) {
                    int x = stack.pollLast();   
                    if(x == -1) continue;
                    if(x > ans) ans = x;
                    map[idx--][i] = x;
                }
                while(idx >= 0)
                    map[idx--][i] = 0;
            }
        } else if(d == 2) {
            // 왼쪽으로
            for(int i = 0; i < N; i++) { 
                Deque<Integer> stack = new ArrayDeque<>();
                
                for(int j = 0; j < N; j++) { 
                    if(map[i][j] == 0) continue;
                    if(!stack.isEmpty() && map[i][j] == stack.peekFirst()){
                        stack.addFirst(stack.pollFirst() * 2);
                        stack.addFirst(-1);
                    }
                    else stack.addFirst(map[i][j]);
                }
    
                int idx = 0;
                while(!stack.isEmpty()) {
                    int x = stack.pollLast();   
                    if(x == -1) continue;
                    if(x > ans) ans = x;
                    map[i][idx++] = x;
                }
                while(idx < N)
                    map[i][idx++] = 0;
            }
        } else if(d == 3){
            // 오른쪽으로
            for(int i = 0; i < N; i++) {
                Deque<Integer> stack = new ArrayDeque<>();
                
                for(int j = N - 1; j >= 0; j--) { 
                    if(map[i][j] == 0) continue;
                    if(!stack.isEmpty() && map[i][j] == stack.peekFirst()){
                        stack.addFirst(stack.pollFirst() * 2);
                        stack.addFirst(-1);
                    }
                    else stack.addFirst(map[i][j]);
                }
    
                int idx = N - 1;
                while(!stack.isEmpty()) {
                    int x = stack.pollLast();  
                    if(x == -1) continue;
                    if(x > ans) ans = x;
                    map[i][idx--] = x;
                }
                while(idx >= 0)
                    map[i][idx--] = 0;
            }
        }
    }

    public static void dfs(int cnt){
        if(cnt == 5) return;

        for(int d = 0; d < 4; d++) {
            int[][] tmp = new int[N][N];
            for(int i = 0 ; i < N; i++) System.arraycopy(map[i], 0, tmp[i], 0, N);
            moveBlocks(d);
            dfs(cnt + 1);
            for(int i = 0 ; i < N; i++) System.arraycopy(tmp[i], 0, map[i], 0, N);
        }
    }
}