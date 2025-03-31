import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static long[] A = new long[6];
    static long[] faces = new long[3];
    static long[] mnFaces = new long[3];
    static boolean[] visit = new boolean[6];
    static long N, tot = 0, ans = Long.MAX_VALUE;
    static long mn = Long.MAX_VALUE, mx = 0, one, two, three;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Long.parseLong(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 6; i++) {
            A[i] = Long.parseLong(st.nextToken());
            tot += A[i];
            if(A[i] > mx) mx = A[i];
        }
        
        if(N == 1){
            // 5면합
            ans = tot - mx;
        } else {
            findMinFaces(0, 0, 0);
            Arrays.sort(mnFaces);
            
            one = mnFaces[0];
            two = one + mnFaces[1];
            three = two + mnFaces[2];
            
            if(N == 2) {
                // 3면합 * 4 + 2면합 * 4
                ans = three * 4 + two * 4;
            } else {
                // 3면합 * 4
                // 2면합 * (8 * (N - 2) + 4)
                // 1면합 * (4 * (N - 2까지 짝수 누적합) + (N - 2) * (N - 2))
                long offset = N - 2;
                ans = three * 4 + two * (8 * offset + 4);
                long acc = 0;
                for(long i = 1; i <= N - 2; i++) acc += 2 * i;
                ans += one * (acc * 4 + offset * offset);            
            }
        }
        
        bw.write(Long.toString(ans));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void findMinFaces(int cnt, int idx, long sum) {
        if(cnt == 3) {
            if(sum < mn) {
                mn = sum;
                for(int i = 0; i < 3; i++) mnFaces[i] = faces[i];
            }
        }
        for(int i = idx; i < 6; i++) {
            if(visit[i] || visit[5 - i]) continue;
            visit[i] = true;
            faces[cnt] = A[i];
            findMinFaces(cnt + 1, idx + 1, sum + A[i]);
            visit[i] = false;
        }
    }
}