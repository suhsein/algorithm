import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        
        String str = br.readLine();
        double[] arr = new double[N + 1];
        for(int i = 0; i < N; i++) arr[i] = Double.parseDouble(br.readLine());
        
        Deque<Double> st = new ArrayDeque<>();
        
        for(char c : str.toCharArray()){
            if(c >= 'A' && c <= 'Z') {
                st.addFirst(arr[c - 'A']);
                continue;
            }
            else {
                double b = st.removeFirst();
                double a = st.removeFirst();
                double tmp = operate(a, b, c);
                st.addFirst(tmp);               
            }
        }
        
        bw.write(String.format("%.2f", st.removeFirst()));
        
        br.close();
        bw.flush();
        bw.close();
    }
    public static double operate(double a, double b, char op){
        switch(op) {
            case '+' : return a + b;
            case '-' : return a - b;
            case '*' : return a * b;
            case '/' : return a / b;
        }
        return -1.0;
    }
}