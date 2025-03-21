import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        
        int idx1 = 0, idx2 = 0;
        
        for(int i = 0; i < N; i++){
            arr[i] = br.readLine();
            if(arr[i].equals("KBS1")) idx1 = i;
            if(arr[i].equals("KBS2")) idx2 = i;
        }
        
        if(idx1 > idx2) idx2++; // KBS1 올리면 KBS2 밀리므로 한 칸 추가
        
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        
        String one = new String("1");
        String four = new String("4");
        
        sb.append(one.repeat(idx1));
        sb.append(four.repeat(idx1));
        sb.append(one.repeat(idx2));
        sb.append(four.repeat(idx2 - 1));
       
        System.out.println(sb.toString());
    }
}