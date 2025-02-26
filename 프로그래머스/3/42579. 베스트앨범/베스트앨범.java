import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        int n = genres.length;
        Map<String, Integer> sum = new HashMap<>();
        Map<String, List<Pair>> all = new HashMap<>();
        
        for(int i = 0; i < n; i++)
            sum.put(genres[i], sum.getOrDefault(genres[i], 0) + plays[i]);
        
        List<Map.Entry<String, Integer>> sumList = sum.entrySet().stream().collect(Collectors.toList());
        
        sumList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
       
        for(int i = 0; i < n; i++) {
            all.put(genres[i], all.getOrDefault(genres[i], new ArrayList<>()));
            all.get(genres[i]).add(new Pair(i, plays[i]));
        }
        
        for(Map.Entry<String, Integer> e : sumList){
            List<Pair> cur = all.get(e.getKey());
            Collections.sort(cur);
            for(int i = 0; i < Math.min(cur.size(), 2); i++)
                answer.add(cur.get(i).idx);
        }
        
        return answer
            .stream()
            .mapToInt(i -> i)
            .toArray();
    }
}

class Pair implements Comparable<Pair> { 
    public int idx;
    public int play;

    Pair(int idx, int play){
        this.idx = idx;
        this.play = play;
    }
    
    public int compareTo(Pair p){
        if(this.play == p.play) return this.idx - p.idx;
        return p.play - this.play;
    }
}