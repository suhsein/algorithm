import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Double H = Double.parseDouble(st.nextToken());
        Double W = Double.parseDouble(st.nextToken());
        Double N = Double.parseDouble(st.nextToken());
        Double M = Double.parseDouble(st.nextToken());
        
        int a = (int) Math.ceil(H / (N + 1));
        int b = (int) Math.ceil(W / (M + 1));
        
        System.out.println(a*b);
    }
}