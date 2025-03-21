import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int S = sc.nextInt();
        N++; // N을 증가시키는 이유는 1-based 인덱스 처리 때문
        int res = Integer.MAX_VALUE; // 최소 길이를 찾기 위해 큰 값으로 초기화
        
        // 수열의 누적합을 담을 배열 생성
        int[] v = new int[N];
        
        // 누적합 계산
        for (int i = 1; i < N; i++) {
            int x = sc.nextInt();
            v[i] = v[i - 1] + x;
        }
        
       
        // 두 포인터 기법을 사용하여 최소 길이 찾기
        for (int l = 0, r = 0; l < N; l++) {
            while (r < N && v[r] - v[l] < S) {
                r++;
            }
            if (r == N) break; // 조건을 만족할 수 없는 경우 종료
            res = Math.min(res, r - l);
        }
        
        // 결과 출력
        if (res == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(res);
        }
        
        sc.close();
    }
}
