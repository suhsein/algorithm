import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        int sz = N * N;
        int[] arr = new int[sz];
      
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++)
                arr[i * N + j] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        bw.write(Integer.toString(arr[sz - N]));
            
        br.close();
        bw.flush();
        bw.close();
    }
}