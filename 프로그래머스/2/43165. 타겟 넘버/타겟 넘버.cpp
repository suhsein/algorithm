#include <string>
#include <vector>
#include <iostream>
using namespace std;

int answer = 0, t, n;
vector<int> arr;

void dfs(int cnt, int sum){
    if(cnt == n){
        if(sum == t) answer++;
        return;
    }
    
    dfs(cnt + 1, sum + arr[cnt]);
    dfs(cnt + 1, sum - arr[cnt]);
}

int solution(vector<int> numbers, int target) {
    arr = numbers;
    t = target;
    n = numbers.size();
    
    dfs(0, 0);
    
    return answer;
}