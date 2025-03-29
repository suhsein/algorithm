import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] mid;
        PriorityQueue<Integer> maxHeap, minHeap; 
        int mCount = 0;
            
        while(T-- > 0) {
            int M = Integer.parseInt(br.readLine());
            mid = new int[M];
            maxHeap = new PriorityQueue<>();
            minHeap = new PriorityQueue<>(Comparator.reverseOrder());
            
            mCount = 0;
            
            int tmp = M, cnt = 0;
            while(tmp > 0) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int i = 0; i < Math.min(tmp, 10); i++) {
                    int x =  Integer.parseInt(st.nextToken());
                    if(maxHeap.isEmpty() || x >= maxHeap.peek()) maxHeap.add(x);
                    else minHeap.add(x);

                    if(maxHeap.size() - minHeap.size() > 1) minHeap.add(maxHeap.poll());
                    else if(maxHeap.size() < minHeap.size()) maxHeap.add(minHeap.poll());
                    
                    int idx = cnt * 10 + i;
                    if(idx % 2 == 0) mid[mCount++] = maxHeap.peek();
                }
                tmp -= 10; cnt++;
            }

            bw.write(Integer.toString(mCount) + "\n");
            for(int i = 0; i < mCount; i++){
                bw.write(Integer.toString(mid[i]) + " ");
                if(i != 0 && (i + 1) % 10 == 0) bw.write("\n");
            }
            if(mCount % 10 != 0) bw.write("\n");
        }
    
        bw.flush();
        br.close();
        bw.close();
    }
}