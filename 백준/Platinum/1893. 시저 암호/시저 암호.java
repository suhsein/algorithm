import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    static char[] A;
    static char[] W;
    static char[] S;
    static char[] D;
    static int alen, wlen, slen;
    static Map<Character, Integer> m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        while(N-- > 0) {
            A = br.readLine().toCharArray();
            W = br.readLine().toCharArray();
            S = br.readLine().toCharArray();

            alen = A.length;
            wlen = W.length;
            slen = S.length;
            m = new HashMap<>();
            
            for(int i = 0; i < alen; i ++) 
                m.put(A[i], i);

            List<Integer> ans = new ArrayList<>();
            
            for(int X = 0; X < A.length; X++){
                D = decode(X);
                sb.setLength(0);
                boolean able = KMP();
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

    public static boolean KMP() {
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
    public static char[] decode(int X) {
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