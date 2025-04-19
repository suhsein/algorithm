import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while(N-- > 0) {
            char[] A = br.readLine().toCharArray();
            char[] W = br.readLine().toCharArray();
            char[] S = br.readLine().toCharArray();

            int alen = A.length, wlen = W.length, slen = S.length;
            Map<Character, Integer> m = new HashMap<>();
            
            for(int i = 0; i < alen; i ++) 
                m.put(A[i], i);

            List<Integer> ans = new ArrayList<>();
            
            for(int X = 0; X < alen; X++){
                char[] D = decode(X, sb, S, A, slen, alen, m);
                sb.setLength(0);
                boolean able = KMP(W, D, wlen, slen);
                if(able) ans.add(X);
            }

            if(ans.size() == 0) {
                bw.write("no solution\n");
            } else if(ans.size() == 1) {
                bw.write("unique: " + Integer.toString(ans.get(0)) + "\n");
            } else {
                bw.write("ambiguous: ");
                for(int x : ans) {
                    bw.write(Integer.toString(x) + " ");
                }
                bw.write("\n");
            }
        }
        
        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean KMP(char[] W, char[] D, int wlen, int slen) {
        int[] pi = new int[wlen];

        int j = 0, cnt = 0;
        for(int i = 1; i < wlen; i++){
            while(j > 0 && W[i] != W[j]) j = pi[j - 1];
            if(W[i] == W[j]) pi[i] = ++j;
        }

        j = 0;
        for(int i = 0; i < slen; i++){
            while(j > 0 && D[i] != W[j]) j = pi[j - 1];
            if(D[i] == W[j]) {
                j++;
                if(j == wlen) {
                    cnt++;
                    j = pi[j - 1];
                }
            }
        }
        return (cnt == 1);
    }
    public static char[] decode(int X, StringBuilder sb, char[] S, char[] A, int slen, int alen, Map<Character, Integer> m) {
        if(X == 0) return S;
        for(int i  = 0; i < slen; i++){
            int idx = m.get(S[i]) - X;
            if (idx < 0) idx += alen;
            char cur = A[idx];
            sb.append(cur);
        }
        return sb.toString().toCharArray();
    }
}