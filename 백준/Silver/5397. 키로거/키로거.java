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
        ListIterator<Character> iter;
        
        while(T-- > 0){
            str = br.readLine();
            list = new LinkedList<>();
            iter = list.listIterator();
            
            for(char c : str.toCharArray()){
                if(c == '<') {
                    if(iter.hasPrevious()) iter.previous();
                    continue;
                }
                if(c == '>'){
                    if(iter.hasNext()) iter.next();
                    continue;
                }
                if(c == '-'){
                    if(iter.hasPrevious()){
                        iter.previous();
                        iter.remove();
                    }
                    continue;
                }
                iter.add(c);
            }
            for(char c : list) bw.write(c);
            bw.write("\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}