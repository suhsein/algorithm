#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

int solution(int N, int number) {
    unordered_set<int> s[9];
    
    int x = N;
    for(int i = 1; i < 9; i++){
        s[i].insert(x);
        x = x * 10 + N;
    }
    
    for(int i = 2; i < 9; i++){
        for(int j = 1; j < i; j++){
            for(int a : s[j]) {
                for(int b : s[i-j]) {
                    s[i].insert(a+b);
                    s[i].insert(a*b);
                    s[i].insert(a-b);
                    if(b != 0) s[i].insert(a/b);
                }
            }
        }
    }
    
    for(int i = 1; i < 9; i++){
        if(s[i].find(number) != s[i].end()) return i;
    }
    return -1;
}