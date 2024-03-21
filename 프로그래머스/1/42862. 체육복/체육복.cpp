#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool l[35], r[35];
int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = n - lost.size();
    for(auto x: lost) l[x] = 1;
    for(auto x: reserve) r[x] = 1;
    for(int i = 1; i <= n; i++) {
        if(l[i] && r[i]) {
            l[i] = r[i] = 0;
            answer++;
        }
    }
    for(int i = 1; i <= n; i++){
        if(l[i]) {
            if(r[i-1]) {
                answer++;
                r[i-1] = 0;
            }
            else if(r[i+1]){
                answer++;
                r[i+1] = 0;
            }
        }
    }
    
    return answer;
}