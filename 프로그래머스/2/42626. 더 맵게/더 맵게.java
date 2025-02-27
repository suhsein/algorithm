import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int s : scoville)
            minHeap.add(s);
        
        while(minHeap.size() >= 2 && minHeap.peek() < K){
            int a = minHeap.poll();
            int b = minHeap.poll();
            int c = a + b * 2;
            answer++;
            
            minHeap.add(c);
        }
        
        
        if(minHeap.peek() < K) return -1;
        return answer;
    }
}