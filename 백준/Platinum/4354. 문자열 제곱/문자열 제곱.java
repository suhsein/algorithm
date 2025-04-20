import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            char[] S = br.readLine().toCharArray();
            int n = S.length, j = 0;
            
            if(n == 1 && S[0] == '.') break;

            int[] pi = new int[n];
            
            for(int i = 1; i < n; i++) {
                while(j > 0 && S[i] != S[j]) j = pi[j -  1];
                if(S[i] == S[j]) pi[i] = ++j;
            }

            int p = n - pi[n - 1];
            int ans = (n % p == 0) ? n / p : 1;
            bw.write(Integer.toString(ans) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}