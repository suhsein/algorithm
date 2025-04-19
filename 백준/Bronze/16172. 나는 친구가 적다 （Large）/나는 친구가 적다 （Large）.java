import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        char[] P = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray())
            if(!(c >= '0' && c <= '9')) sb.append(c);

        char[] S = sb.toString().toCharArray();

        int n = S.length, m = P.length;
        int j = 0;
        int[] pi = new int[m];
        
        for(int i = 1; i < m; i++){
            while(j > 0 && P[i] != P[j]) j = pi[j - 1];
            if(P[i] == P[j]) pi[i] = ++j;
        }

        j = 0;
        boolean flag = false;
        for(int i = 0; i < n; i++) {
            while(j > 0 && S[i] != P[j]) j = pi[j - 1];
            if(S[i] == P[j]) {
                j++;
                if(j == m) {
                    flag = true;
                    break;
                }
            }
        }        
        
        br.close();
        bw.write(flag ? "1" : "0");
        bw.flush();
        bw.close();
    }
}