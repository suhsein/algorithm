#include <string>
#include <vector>
#include <queue>
#include <iostream>
#define X first
#define Y second

using namespace std;

int arr[20005], mx;
vector<int> adj[20005];

void solve(int &n){
    queue<int> q;
    
    q.push(1);
    
    while(!q.empty()){
        int x = q.front(); q.pop();
        for(auto a: adj[x]){
            if(arr[a] == n + 5) {
                q.push(a);
                arr[a] = arr[x] + 1;
                if(arr[a] > mx) mx = arr[a];
            }
        }
    }
}

int solution(int n, vector<vector<int>> edge) {
    int answer = 0;
    
    for(int i = 2; i<= n ;i++) arr[i] = n + 5;
    for(auto e: edge){
        adj[e[0]].push_back(e[1]);
        adj[e[1]].push_back(e[0]);
    }
    solve(n);
    
    for(int i =2; i<=n ;i++) if(arr[i] == mx) answer++;
    
    return answer;
}