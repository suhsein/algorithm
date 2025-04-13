import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String nums = br.readLine();

        for(char num : nums.toCharArray()) 
            ans += (num - '0');
        
        br.close();
        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
    }
}