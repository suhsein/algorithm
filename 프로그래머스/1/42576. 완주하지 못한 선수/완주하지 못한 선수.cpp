#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    unordered_map<string, int> m;
    for(auto p: participant) m[p]++;
    for(auto c: completion) {
        if(m.find(c) == m.end() || m[c] == 0) return c;
        m[c]--;
    }
    for(auto p: participant) if(m[p] != 0) return p;
}