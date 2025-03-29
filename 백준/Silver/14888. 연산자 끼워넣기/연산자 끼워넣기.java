import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    static int[] A;
    static int[] op = new int[4];
    static int mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        init();
        calc(A[0], 0);
        
        bw.write(Integer.toString(mx) + "\n" + Integer.toString(mn));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void calc(int x, int cnt){
        if(cnt == N - 1) {
            if(x > mx) mx = x;
            if(x < mn) mn = x;
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(op[i] == 0) continue;
            op[i]--;
            switch(i) {
                case 0 : calc(x + A[cnt + 1], cnt + 1); break;
                case 1 : calc(x - A[cnt + 1], cnt + 1); break;
                case 2 : calc(x * A[cnt + 1], cnt + 1); break;
                case 3 : calc(x / A[cnt + 1], cnt + 1); break;
            };
            op[i]++;
        }
    }
    
    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 4; i++) 
            op[i] = Integer.parseInt(st.nextToken());
    }
}