import java.util.*;
import java.io.*;

public class Main {
    static final int DWARFS = 9;
    static boolean[] visit = new boolean[DWARFS];
    static int[] arr;
    static BufferedWriter bw;
    static boolean flag = false; 
    static int all = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
  
        arr = new int[DWARFS];
        for(int i = 0; i < DWARFS; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            all += arr[i];
        }
            
        dfs(0, 0);
        br.close();
        bw.flush();
        bw.close();
    }
    public static void dfs(int tot, int cnt) throws IOException {
        if(cnt == 2) {
            if(all - tot != 100) return;
            for(int i = 0; i < DWARFS; i++)
                if(!visit[i]) bw.write(arr[i] + "\n");
            flag = true; return;
        }
        for(int i = 0; i < DWARFS; i++){
            if(visit[i]) continue;
            visit[i] = true;
            dfs(tot + arr[i], cnt + 1);
            if(flag) return;
            visit[i] = false;
        }
    }
}