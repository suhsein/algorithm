import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int n = info.length, m = query.length;
        int[] answer = new int[m];
        
        Map<String, List<Integer>> map = new HashMap<>();
        map = makeMap(n, info, map);
        
        StringTokenizer st;
        int idx = 0, cnt, score;
        String language, position, experience, soulFood, str;
        StringBuilder sb = new StringBuilder();
        
        for(Map.Entry<String, List<Integer>> e : map.entrySet()) {
            List<Integer> list = e.getValue();
            Collections.sort(list);
        }
        
        for(String q : query){
            cnt = 0;
            st = new StringTokenizer(q, " ");
            language = st.nextToken();
            st.nextToken();
            position = st.nextToken();
            st.nextToken();
            experience = st.nextToken();
            st.nextToken();
            soulFood = st.nextToken();
            score = Integer.parseInt(st.nextToken());
            
            sb.append(language); sb.append(position); sb.append(experience); sb.append(soulFood);
            str = sb.toString();
            sb.setLength(0);
            
            if(map.containsKey(str)) 
                answer[idx] = binarySearch(map.get(str), score);
            idx++;
        }
        
        return answer;
    }
    
    public static int binarySearch(List<Integer> list, int score) {
        int lo = -1, hi = list.size(), m;
        
        while(lo + 1 < hi) {
            m = (lo + hi) / 2;
            if(list.get(m) < score) lo = m;
            else hi = m;
        }
        
        return list.size() - hi;
    }
    
    public static Map<String, List<Integer>>
        makeMap(int n, String[] info, Map<String, List<Integer>> map){
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int i = 0, score;
        String[] language = {"-", ""};
        String[] position = {"-", ""};
        String[] experience = {"-", ""};
        String[] soulFood = {"-", ""};
        String str;
        
        for(String s : info) { 
            st = new StringTokenizer(s, " ");
            language[1] = st.nextToken();
            position[1] = st.nextToken();
            experience[1] = st.nextToken();
            soulFood[1] = st.nextToken();
            score = Integer.parseInt(st.nextToken());
            
            for(String l : language){
                for(String p : position){
                    for(String e : experience) {
                       for(String so : soulFood) {
                            sb.append(l); sb.append(p); sb.append(e); sb.append(so);
                            str = sb.toString();
                            map.put(str, map.getOrDefault(sb.toString(), new ArrayList<>()));
                            map.get(str).add(score);
                            sb.setLength(0);
                        } 
                    }
                }
            }
        }
        
        return map;
    }
    
}