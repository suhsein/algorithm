import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), x;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;
            return Math.abs(o1) - Math.abs(o2);
        });
        
        while(N-- > 0){
            x = Integer.parseInt(br.readLine());
            if(x != 0) pq.add(x);
            else System.out.println(pq.isEmpty() ? 0 : pq.poll());
        }
        
    }
}