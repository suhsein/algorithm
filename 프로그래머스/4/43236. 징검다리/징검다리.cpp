#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(int distance, vector<int> rocks, int n) {
    rocks.push_back(distance);
    sort(rocks.begin(), rocks.end());
   
    int l = 0, r = distance + 1, m, prev, cnt, answer = 0;
    while(l < r){
        m = (l + r) / 2;
        cnt = 0, prev = 0;
        for(int i = 0; i< rocks.size(); i++){
            if(rocks[i] - prev < m) cnt++;
            else prev = rocks[i];
        }
        if(cnt > n) r = m;
        else {
            answer = max(answer, m);
            l = m + 1;
        }
    }
    return answer;
}