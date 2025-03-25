import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        String str;
        int idx = 0;
        List<Character> list;
        
        while(T-- > 0){
            str = br.readLine();
            list = new LinkedList<>();
            idx = 0;
            for(char c : str.toCharArray()){
                if(c == '<') {
                    if(idx > 0) idx--;
                    continue;
                }
                if(c == '>'){
                    if(idx < list.size()) idx++;
                    continue;
                }
                if(c == '-'){
                    if(idx > 0) list.remove(--idx);
                    continue;
                }
                list.add(idx++, c);
            }
            for(char c : list) bw.write(c);
            bw.write("\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}