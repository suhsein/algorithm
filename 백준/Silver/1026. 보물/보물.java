import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static Integer[] A;
    static Integer[] B;
    static int N, ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        A = new Integer[N];
        B = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) B[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);
        Arrays.sort(B, Comparator.reverseOrder());

        for(int i = 0; i < N; i++) ans += A[i] * B[i];
           
        bw.write(Integer.toString(ans));
        bw.flush();
        br.close();
        bw.close();
    }
}