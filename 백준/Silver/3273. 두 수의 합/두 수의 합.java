import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Integer> map = new HashMap<>();
        
        int n = Integer.parseInt(br.readLine()); 
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int x = Integer.parseInt(br.readLine());

        Integer answer = 0 ;

        for(int i = 0; i < n; i++) {
            if(map.get(x - arr[i]) == null) continue; 
            answer += map.get(x - arr[i]);
        }
        
        bw.write(Integer.toString(answer / 2));
        bw.flush();
        br.close();
        bw.close();
    }
}