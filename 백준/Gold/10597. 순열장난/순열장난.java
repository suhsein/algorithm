import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static boolean[] visit;
    static boolean found = false;
    static String str, ans = "";
    static int sz, N;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        str = br.readLine();
        sz = str.length();
        N = sz < 9 ? sz : 9 + (sz - 9) / 2;

        visit = new boolean[N + 1];
        bt(0, new int[] {});
        
        
        br.close();
        bw.flush();
        bw.close();
    }

    public static void bt(int idx, int[] arr) throws IOException {
        if(arr.length == N) {
            found = true;
            for(int x : arr) bw.write(Integer.toString(x) + " ");
            return;
        }

        int cur = str.charAt(idx) - '0';
        
        if(cur == 0) return;
        
        if(cur <= N && !visit[cur]) {
            visit[cur] = true;
            int nLen = arr.length + 1;
            int[] narr = Arrays.copyOf(arr, nLen);
            narr[nLen - 1] = cur;
            bt(idx + 1, narr);
            if(found) return;
            visit[cur] = false;
        }
        if(idx + 1 < sz) {
            cur = Integer.parseInt(str.substring(idx, idx + 2));
            if(cur <= N && !visit[cur]){
                visit[cur] = true;
                int nLen = arr.length + 1;
                int[] narr = Arrays.copyOf(arr, nLen);
                narr[nLen - 1] = cur;
                bt(idx + 2, narr);
                if(found) return;
                visit[cur] = false;
            }
        }
    }
}