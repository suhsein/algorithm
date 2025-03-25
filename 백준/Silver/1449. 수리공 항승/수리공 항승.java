import java.util.*;
import java.io.*;
import java.lang.Comparable;

public class Main {
    static BufferedWriter bw;
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         bw = new BufferedWriter(new OutputStreamWriter(System.out));
         StringTokenizer st;
        
         st = new StringTokenizer(br.readLine(), " ");
         int N = Integer.parseInt(st.nextToken());
         double L = Double.parseDouble(st.nextToken());
         
         double[] arr = new double[N];
         st = new StringTokenizer(br.readLine(), " ");

         for(int i = 0; i < N; i++)
              arr[i] = Double.parseDouble(st.nextToken());
         
         Arrays.sort(arr);
         
         double cur = L;
         int ans = 0;
         
         for(double d : arr){
             if(cur == L || cur < (d + 0.5)) {
                 cur = d + L - 0.5;
                 ans++;
                 continue;
             }
         }
                    
         bw.write(Integer.toString(ans));
         br.close();
         bw.flush();
         bw.close();
    }
    
   
}