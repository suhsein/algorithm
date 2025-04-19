import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] S = br.readLine().toCharArray();
        char[] P = br.readLine().toCharArray();

        int n = S.length, m = P.length;
        int[] pi = new int[m];

        int j = 0;
        for(int i = 1; i < m; i++) {
            while(j > 0 && P[i] != P[j]) j = pi[j - 1];
            if(P[i] == P[j]) pi[i] = ++j;
        }

        int ans = 0;
        StringBuilder sb = new StringBuilder();

        j = 0;
        for(int i = 0; i < n; i ++) {
            while(j > 0 && S[i] != P[j]) j = pi[j - 1];
            if(S[i] == P[j]) {
                j++;
                if(j == m) {
                    ans++;
                    sb.append(i - m + 2 + " ");
                    j = pi[j - 1];
                }
            }
        }

        bw.write(Integer.toString(ans) + "\n" + sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}