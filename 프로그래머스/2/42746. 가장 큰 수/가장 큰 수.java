import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] arr = Arrays.stream(numbers).boxed()
            .map(String::valueOf).toArray(String[]::new);
        
        Arrays.sort(arr, (a, b) -> Integer.parseInt(b+a) - Integer.parseInt(a+b));

        if(arr[0].equals("0")) answer = "0";
        else for(String x : arr) answer += x;
        
        return answer;
    }
}