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
        List<Integer> list;
        int mCount = 0;
            
        while(T-- > 0) {
            int M = Integer.parseInt(br.readLine());
            mid = new int[M];
            list = new ArrayList<>();
            
            mCount = 0;
            
            int tmp = M, cnt = 0;
            while(tmp > 0) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int i = 0; i < Math.min(tmp, 10); i++) {
                    list.add(Integer.parseInt(st.nextToken()));
                    Collections.sort(list);
                    int idx = cnt * 10 + i;
                    if(idx % 2 == 0) mid[mCount++] = list.get(idx / 2);
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