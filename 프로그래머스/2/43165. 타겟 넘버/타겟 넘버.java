import java.util.*;

class Solution {
    public int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int sum, int cnt) {
        if(cnt == numbers.length) {
            if(sum == target) answer++;
            return;
        }
        dfs(numbers, target, sum + numbers[cnt], cnt + 1);
        dfs(numbers, target, sum - numbers[cnt], cnt + 1);
    }
}