import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();

        int n = S.length;
        int[] pi = new int[n];

        int j = 0;
        for(int i = 1; i < n; i++){
            while(j > 0 && S[i] != S[j]) j = pi[j - 1];
            if(S[i] == S[j]) pi[i] = ++j;
        }

        bw.write(Integer.toString(n - pi[n - 1]));
        br.close();
        bw.flush();
        bw.close();
    }
}