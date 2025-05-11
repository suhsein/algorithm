import java.util.*;

class Solution {
    public int solution(String[] words) {
        int answer = 0;
        
        Trie t = new Trie();
        
        for(String s : words) 
            t.insert(s);    
        
        for(String s : words)
            answer += t.find(s);
        
        return answer;
    }
    
    class TrieNode {
        TrieNode[] nxt;
        boolean endOfWord;
        int nxtCnt;
        
        public TrieNode() {
            nxt = new TrieNode[26];
            endOfWord = false;
            nxtCnt = 0;
        }
    }
    
    class Trie {
        TrieNode ROOT;
        
        public Trie() {
            ROOT = new TrieNode();
        }
        
        void insert(String s) {
            TrieNode cur = ROOT;
            
            for(char c : s.toCharArray()) {
                if(cur.nxt[ctoi(c)] == null)
                    cur.nxt[ctoi(c)] = new TrieNode();
                cur.nxtCnt++;
                cur = cur.nxt[ctoi(c)];
            }
            
            cur.nxtCnt++;
            cur.endOfWord = true;
        }
        
        int find(String s) {
            TrieNode cur = ROOT;
            
            for(int i = 0; i < s.length(); i++) {
                cur = cur.nxt[ctoi(s.charAt(i))];
                if(cur.nxtCnt == 1) return i + 1;
            }
            
            return s.length();
        }
        
        int ctoi(char c){
            return c - 'a';
        }
    }
}