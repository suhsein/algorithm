#include <string>
#include <vector>
#include <queue>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(vector<vector<int>> jobs) {
    int t = 0, answer = 0, i = 0;
    sort(jobs.begin(), jobs.end());
    priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
    
    while(i < jobs.size() || !pq.empty()) {
        if(pq.empty() && jobs[i][0] > t) t = jobs[i][0];
        while(i < jobs.size() && jobs[i][0] <= t){
            pq.push({jobs[i][1], jobs[i][0]});
            i++;
        }
        if(!pq.empty()){
            auto x = pq.top(); pq.pop();
            t += x.first;
            answer += t - x.second;
        }
    }
    return answer / jobs.size();
}