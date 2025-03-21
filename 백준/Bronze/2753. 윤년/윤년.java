import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());
        
        String ans;
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ans = "1";
        else ans = "0";
        
        
        System.out.println(ans);
    }
}