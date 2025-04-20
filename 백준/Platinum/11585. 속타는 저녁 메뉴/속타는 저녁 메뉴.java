import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        char[] P = new char[N];
        char[] S = new char[N];

        init(br, N, P);
        init(br, N, S);

        int[] pi = new int[N];
        int j = 0;
        for(int i = 1; i < N; i++){
            while(j > 0 && P[i] != P[j]) j = pi[j - 1];
            if(P[i] == P[j]) pi[i] = ++j;
        }

        int p = N - pi[N - 1];
        bw.write(Integer.toString(1) + "/" + Integer.toString((N % p == 0) ? p : N));
        br.close();
        bw.flush();
        bw.close();
    }
  
    public static void init(BufferedReader br, int N, char[] arr) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) 
            arr[i] = st.nextToken().charAt(0);
    }
}