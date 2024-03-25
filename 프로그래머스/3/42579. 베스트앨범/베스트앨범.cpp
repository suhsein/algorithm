#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>
#include <iostream>
#define X first
#define Y second
using namespace std;

vector<int> solution(vector<string> genres, vector<int> plays) {
    unordered_map<string, vector<pair<int,int>>> m;
    unordered_map<string, int> sum;
    vector<int> answer;
    int n = genres.size();
    
    for(int i = 0; i < n; i++){
        m[genres[i]].push_back({plays[i],i});
        sum[genres[i]] += plays[i];
    }
    vector<pair<string, int>> v(sum.begin(), sum.end());
    sort(v.begin(), v.end(), [](pair<string,int> &a, pair<string,int> &b){
                            return a.Y > b.Y;});    

    for(auto x: v){
        sort(m[x.X].begin(), m[x.X].end(), [](pair<int,int> &a, pair<int,int> &b){
            if(a.X == b.X) return a.Y < b.Y;
            return a.X > b.X;});
        for(int i = 0; i < min(2, (int)m[x.X].size()); i++) answer.push_back(m[x.X][i].second);
    }
    
    return answer;
}