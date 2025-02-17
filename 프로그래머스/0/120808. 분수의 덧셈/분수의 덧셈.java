class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int idx = 0;
        
        int m = denom1 * denom2; 
        int n = numer1 * denom2 + numer2 * denom1;
        
        int x = 0;
        if(m > n) {
            x = gcd(m, n);
        } else {
            x = gcd(n, m);
        }
        System.out.println(x);
        
        m /= x; 
        n /= x; 
        
        answer[idx++] = n;
        answer[idx++] = m;
        
        return answer;
    }
    
    int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}