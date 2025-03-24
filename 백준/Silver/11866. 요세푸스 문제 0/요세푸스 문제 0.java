import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= N; i++) list.add(i);
        
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        
        List<Integer> ans = new ArrayList<>();
        
        while(!list.isEmpty()) {
            idx += (K - 1);
            idx %= list.size();
            ans.add(list.get(idx));
            list.remove(idx);
        }
        
        sb.append(ans.stream()
            .map(i -> i.toString())
            .collect(Collectors.joining(", ", "<", ">")));
        
        System.out.println(sb.toString());
    }
}