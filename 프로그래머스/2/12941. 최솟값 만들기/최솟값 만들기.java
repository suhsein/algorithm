import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int n = A.length;
        int ans1 = 0, ans2 = 0;
        
        for(int i = 0; i < n; i++){
            ans1 += A[i] * B[n - i - 1];
            ans2 += A[n - i - 1] * B[i];
        }
        
        answer = (ans1 < ans2) ? ans1 : ans2;
        
        return answer;
    }
}