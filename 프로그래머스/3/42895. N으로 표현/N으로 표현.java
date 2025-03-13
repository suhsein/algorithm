import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> set = new ArrayList<>();
        
        int x = N;
        
        set.add(new HashSet<>());
        
        for(int i = 1; i < 9; i++) {
            set.add(new HashSet<>());
            set.get(i).add(x);
            x = x * 10 + N;
        }
        
        for(int i = 2; i < 9; i++){
            for(int j = 1; j < i; j++){
                for(int a : set.get(j)) {
                    for(int b : set.get(i-j)) {
                        set.get(i).add(a + b);
                        set.get(i).add(a * b);
                        set.get(i).add(a - b);
                        if(b != 0) set.get(i).add(a / b);
                    }
                }
            }
        }

        for(int i = 1; i < 9; i++){
            if(set.get(i).contains(number)) return i;
        }
        return -1;

    }
}