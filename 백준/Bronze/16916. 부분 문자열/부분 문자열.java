import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        String P = br.readLine();

        int n = S.length(), m = P.length();
        boolean flag = false;
        int[] pi = new int[P.length()]; // 접두사 기록. 패턴 문자열 길이만큼 할당

        int j = 0;
        for(int i = 1; i < m; i++){
            while(j > 0 && P.charAt(i) != P.charAt(j)) j = pi[j - 1];
            if(P.charAt(i) == P.charAt(j)) pi[i] = ++j;
        }


        j = 0;
        for(int i = 0; i < n; i++){
            while(j > 0 && S.charAt(i) != P.charAt(j)) j = pi[j - 1];
            if(S.charAt(i) == P.charAt(j)) {
                if(j == m - 1){
                    flag = true;
                    break;
                }
                j++;
            }
        }
        
        br.close();
        bw.write(flag ? "1" : "0");
        bw.flush();
        bw.close();
    }
}