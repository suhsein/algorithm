#include <string>
#include <vector>
#include <queue>
#include <unordered_map>
#include <iostream>
#define X first
#define Y second
using namespace std;


int solution(string begin, string target, vector<string> words) {
    int n = words[0].size();
    unordered_map<string, bool> m;
    for(auto w: words) m[w] = 0;
    
    queue<pair<string, int>> q;
    q.push({begin,0});
    
    while(!q.empty()){
        auto cur = q.front(); q.pop();
        string x = cur.X; int cnt = cur.Y;
        
        for(auto w: words){    
            if(m[w]) continue;
            int tmp = 0;
            for(int i = 0; i< n; i++) if(x[i] != w[i]) tmp++;
            if(tmp != 1) continue;
            if(w == target) return cnt + 1;
            m[w] = 1; q.push({w, cnt+1});
        }        
    }

    return 0;
}