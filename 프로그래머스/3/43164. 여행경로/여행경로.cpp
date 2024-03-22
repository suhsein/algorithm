#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<vector<string>> ticket; 
vector<string> answer;
bool v[100005], find_ans;
int sz;

void dfs(string start, int cnt){
    answer.push_back(start);
    if(cnt == sz) {
        find_ans = 1;
        return;
    }
    for(int i = 0; i < sz; i++){
        if(v[i] || ticket[i][0] != start) continue;
        v[i] = 1;
        dfs(ticket[i][1], cnt+1);
        if(find_ans) return;
        answer.pop_back();
        v[i] = 0;
    }
}
vector<string> solution(vector<vector<string>> tickets) {
    sort(tickets.begin(), tickets.end());
    ticket = tickets;
    sz = ticket.size();
    
    dfs("ICN", 0);
    
    return answer;
}