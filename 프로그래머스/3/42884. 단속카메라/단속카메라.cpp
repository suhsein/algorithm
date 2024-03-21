#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

bool cmp(vector<int> &a, vector<int> & b){
    if(a[1] == b[1]) return a[0] < b[0];
    return a[1] < b[1];
}
int solution(vector<vector<int>> routes) {
    sort(routes.begin(), routes.end(), cmp);
    int answer = 0;

    for(int i = 0, j = i + 1; i < routes.size(); i = j, j = i+1){
        int l = routes[i][1];
        while(j < routes.size() && l >= routes[j][0]) {
            j++;
            if(j < routes.size()) l = min(l, routes[j][1]);
        } 
        answer++;
    }
    return answer;
}