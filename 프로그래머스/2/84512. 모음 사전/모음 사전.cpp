#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

string arr[6]= {"A", "E", "I", "O", "U"};
string w;
int cnt = 0, ans = 0;

void dfs(string s){
    cnt++;
    if(ans != 0) return;
    if(s == w) {
        ans = cnt;
        return;
    }
    if(s.size() == 5) return;

    for(int i = 0; i < 5; i++) dfs(s + arr[i]);
}

int solution(string word) {
    w = word;
    dfs("");
    return ans - 1;
}