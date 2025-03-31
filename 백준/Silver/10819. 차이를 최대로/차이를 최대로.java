import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int[] A;
    static int[] P;
    static boolean[] visit;
    static int N, mx = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        P = new int[N];
        visit = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
           
        permutate(0);
        bw.write(Integer.toString(mx));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void permutate(int cnt) {
        if(cnt == N) {
            calc();
            return;
        }
        for(int i = 0; i < N; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            P[cnt] = i;
            permutate(cnt + 1);
            visit[i] = false;
        }
    }

    public static void calc(){
        int tot = 0;
        for(int i = 0; i < N - 1; i++) 
            tot += Math.abs(A[P[i]] - A[P[i + 1]]);
        if(tot > mx) mx = tot;
    }
}