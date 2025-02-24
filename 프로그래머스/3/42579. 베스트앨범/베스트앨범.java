import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        int n = genres.length;
        
        Map<String, Integer> cntMap = new HashMap<>();
        Map<String, List<Pair>> allMap = new HashMap<>();
        
        for(int i = 0; i < n; i++) 
            cntMap.put(genres[i], cntMap.getOrDefault(genres[i], 0) + plays[i]);
        
            
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(cntMap.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        
        for(int i = 0; i < n; i++) {
            if(!allMap.containsKey(genres[i]))
                allMap.put(genres[i], new ArrayList<>());
            
            allMap.get(genres[i]).add(new Pair(i, plays[i]));
        }
        
        for(Map.Entry<String,Integer> e : entryList) {
            Collections.sort(allMap.get(e.getKey()));  
            List<Pair> cur = allMap.get(e.getKey());
            
            for (int i = 0; i < Math.min(cur.size(), 2); i++)
                answer.add(cur.get(i).idx);
            
        }
        
        return answer.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}

class Pair implements Comparable<Pair>{ 
    public int idx;
    public int cnt;
    
    Pair(int idx, int cnt){
        this.idx = idx;
        this.cnt = cnt;
    }
    
    public int compareTo(Pair p){
        if(this.cnt != p.cnt) return Integer.compare(p.cnt, this.cnt); 
        else return Integer.compare(this.idx, p.idx);
    }
}