import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int L, P, V, ans, cnt = 1;
        
        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            L = Integer.parseInt(st.nextToken());    
            P = Integer.parseInt(st.nextToken());    
            V = Integer.parseInt(st.nextToken());   

            if(L == 0 && P == 0 && V == 0) break;
            ans = 0;
            
            while(V > P){
                V -= P;
                ans += L;
            }

            ans += Math.min(L, V);
            bw.write("Case " + cnt++ + ": " + Integer.toString(ans) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}