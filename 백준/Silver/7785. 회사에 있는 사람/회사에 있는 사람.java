import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> s = new TreeSet<>(Comparator.reverseOrder());
        String name, status;
        
        while(N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
            name = st.nextToken(); status = st.nextToken();
            if(status.equals("enter")) s.add(name);
            else if(status.equals("leave")) s.remove(name);
        }
        
        for(String x : s.toArray(new String[0])) System.out.println(x);
    }
}