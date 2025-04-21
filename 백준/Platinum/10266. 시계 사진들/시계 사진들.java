import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    final static int MX = 360000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int A[] = new int[n];
        int B[] = new int[n];

        A = init(A, n);
        B = init(B, n);


        String ans = KMP(A, B, n);

        bw.write(ans);
        br.close();
        bw.flush();
        bw.close();
    }

    public static String KMP(int[] A, int[] B, int n){
        int P[] = new int[2 * n];
        
        for(int i = 0; i < 2 * n; i++) 
            P[i] = B[i % n];

        int pi[] = new int[n];

        int j = 0;
        for(int i = 1; i < n; i++){
            while(j > 0 && A[i] != A[j]) j = pi[j - 1];
            if(A[i] == A[j]) pi[i] = ++j;
        }

        j = 0;
        String ans = "impossible";
        
        for(int i = 0; i < 2 * n; i ++) {
            while(j > 0 && P[i] != A[j]) j = pi[j - 1];
            if(P[i] == A[j]) {
                j++;
                if(j == n) {
                    ans = "possible";
                    j = pi[j - 1];
                }
            }
        }

        return ans;
    }

    public static int[] init(int[] ret, int n) throws IOException {
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) 
            arr[i] = Integer.parseInt(st.nextToken());

        return makeArr(arr, ret, n);
    }

    public static int[] makeArr(int[] arr, int ret[], int n) {
        Arrays.sort(arr);
        
        for(int i = 1; i < n; i++)
            ret[i - 1] = arr[i] - arr[i - 1];
        ret[n - 1] = arr[0] + MX - arr[n - 1];
        
        return ret;
    }
  
   
}