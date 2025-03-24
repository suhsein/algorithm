import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = "";
        Map<String, Integer> m = new HashMap<>();
        int mx = 0;
        
        while(N-- > 0){
            str = br.readLine();
            m.put(str, m.getOrDefault(str, 0) + 1);
            if(m.get(str) > mx) mx = m.get(str);
        }
        
        List<String> cand = new ArrayList<>();
        for(Map.Entry<String, Integer> e : m.entrySet())
            if(e.getValue() == mx) cand.add(e.getKey());
        Collections.sort(cand);
        
        System.out.println(cand.get(0));
    }
}