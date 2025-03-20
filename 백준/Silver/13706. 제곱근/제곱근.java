import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        BigInteger N = new BigInteger(br.readLine());
        BigInteger lo = new BigInteger("1");
        BigInteger hi = N;
        BigInteger mid;
        
        while(true){
            mid = lo.add(hi);
            mid = mid.divide(new BigInteger("2"));
            
            int result = (mid.multiply(mid)).compareTo(N);
            if(result == 0) break;
            else if(result == -1) lo = mid;
            else hi = mid;
        }
        
        System.out.println(mid);
    }
}