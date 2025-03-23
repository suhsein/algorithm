import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        
        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);
        
        int mdif = 2000000005;
        int l = 0, r = N - 1, left = 0, right = N - 1, tmp;
        
        while(l < r){
            tmp = Math.abs(arr[l] + arr[r]);
            if(mdif >= tmp) {
                mdif = tmp;
                left = l; right = r;
                if(mdif == 0) break;
            }
            if(arr[l] + arr[r] < 0) l++;
            else r--;
        }
        
        System.out.println(arr[left] + " " + arr[right]);
    }
}